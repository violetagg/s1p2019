package io.spring.speakersservice;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface SpeakersRepository extends ReactiveCrudRepository<Speaker, Long> {
}
