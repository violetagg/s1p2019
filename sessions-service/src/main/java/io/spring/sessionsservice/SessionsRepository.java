package io.spring.sessionsservice;

import org.springframework.data.r2dbc.repository.query.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface SessionsRepository extends ReactiveCrudRepository<Session, Long> {

	@Query("SELECT * FROM sessions WHERE day = :day")
	Flux<Session> findAllByDay(String day);
}
