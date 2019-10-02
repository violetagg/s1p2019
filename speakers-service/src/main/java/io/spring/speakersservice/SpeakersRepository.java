package io.spring.speakersservice;

import org.springframework.data.repository.CrudRepository;

public interface SpeakersRepository extends CrudRepository<Speaker, Long> {
}
