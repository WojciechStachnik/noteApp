package com.stachnik.wojciech.noteApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class NoteAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(NoteAppApplication.class, args);
	}
}
