package io.spring.frontend;

import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;
import java.time.Duration;

@Controller
public class FrontendController {
	final Mono<RSocketRequester> sessionService;
	final Mono<RSocketRequester> speakerService;

	public FrontendController(RSocketRequester.Builder builder) {
		this.sessionService = builder.dataMimeType(MediaType.APPLICATION_JSON)
				.connectWebSocket(URI.create("http://localhost:8081/rsocket"))
				.cache()
				.retryBackoff(5, Duration.ofSeconds(3));

		this.speakerService = builder.dataMimeType(MediaType.APPLICATION_JSON)
				.connectWebSocket(URI.create("http://localhost:8082/rsocket"))
				.cache()
				.retryBackoff(5, Duration.ofSeconds(3));
	}

	@GetMapping("/")
	public String home(Model model) {
		Flux<Speaker> speakers =
				speakerService.flatMapMany(r -> r.route("listSpeakers")
						.data(Mono.empty())
						.retrieveFlux(Speaker.class));
		model.addAttribute("speakers", speakers);
		return "index";
	}

	@GetMapping("/sessions")
	public String sessions(Model model) {
		Flux<Session> sessions =
				sessionService.flatMapMany(r -> r.route("listSessions")
						.data(Mono.empty())
						.retrieveFlux(Session.class));
		model.addAttribute("sessions", sessions);
		return "sessions";
	}
}

