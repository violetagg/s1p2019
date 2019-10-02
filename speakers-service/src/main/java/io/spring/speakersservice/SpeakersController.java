package io.spring.speakersservice;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class SpeakersController {
	private final SpeakersRepository repository;

	public SpeakersController(SpeakersRepository repository) {
		this.repository = repository;
	}

	@MessageMapping("listSpeakers")
	public Flux<Speaker> listSpeakers() {
		return this.repository.findAll();
	}
}
