package io.spring.speakersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.blockhound.BlockHound;

@SpringBootApplication
public class SpeakersServiceApplication {

	public static void main(String[] args) {
		BlockHound.install();

		SpringApplication.run(SpeakersServiceApplication.class, args);
	}

}
