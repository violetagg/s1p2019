package io.spring.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Controller
public class FrontendController {
	private final WebClient webClient;

	public FrontendController(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.build();
	}

	@GetMapping("/")
	public String home(Model model) {
		Flux<Speaker> speakers =
				webClient.get()
						.uri("http://localhost:8082/listSpeakers")
						.retrieve()
						.bodyToFlux(Speaker.class);
		model.addAttribute("speakers", speakers);
		return "index";
	}

	@GetMapping("/sessions")
	public String sessions(Model model) {
		Flux<Session> sessions =
				webClient.get()
						.uri("http://localhost:8081/listSessions")
						.retrieve()
						.bodyToFlux(Session.class);
		model.addAttribute("sessions", sessions);
		return "sessions";
	}
}
