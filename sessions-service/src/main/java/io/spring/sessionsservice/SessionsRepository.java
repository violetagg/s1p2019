package io.spring.sessionsservice;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SessionsRepository extends CrudRepository<Session, Long> {

	@Query("SELECT * FROM sessions WHERE day = :day")
	Optional<List<Session>> findAllByDay(String day);
}
