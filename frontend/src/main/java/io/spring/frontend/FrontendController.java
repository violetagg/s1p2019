package io.spring.frontend;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Controller
public class FrontendController {
	private final RestTemplate restTemplate;

	public FrontendController(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	@GetMapping("/")
	public String home(Model model) throws URISyntaxException {
		model.addAttribute("speakers", restTemplate.exchange(
				get("http://localhost:8082/listSpeakers"),
				new ParameterizedTypeReference<Iterable<Speaker>>() {
				}).getBody());
		return "index";
	}

	@GetMapping("/sessions")
	public String sessions(Model model) throws URISyntaxException {
		Iterable<Session> sessions = restTemplate.exchange(
				get("http://localhost:8081/listSessions"),
				new ParameterizedTypeReference<Iterable<Session>>() {
				}).getBody();
		model.addAttribute("sessions", sessions);
		return "sessions";
	}

	private RequestEntity<?> get(String uri) throws URISyntaxException {
		return RequestEntity
				.get(new URI(uri))
				.accept(APPLICATION_JSON)
				.build();
	}
}
