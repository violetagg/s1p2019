package io.spring.speakersservice;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpeakersController {
	private final SpeakersRepository repository;

	public SpeakersController(SpeakersRepository repository) {
		this.repository = repository;
	}

	@GetMapping(path = "/listSpeakers", produces = MediaType.APPLICATION_JSON_VALUE)
	public Iterable<Speaker> listSpeakers() {
		return this.repository.findAll();
	}
}
