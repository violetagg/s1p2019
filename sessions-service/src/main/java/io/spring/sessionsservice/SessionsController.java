package io.spring.sessionsservice;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class SessionsController {
	private final SessionsRepository repository;

	public SessionsController(SessionsRepository repository) {
		this.repository = repository;
	}

	@MessageMapping("listSessions")
	public Flux<Session> listSessions() {
		return this.repository.findAll();
	}
}
