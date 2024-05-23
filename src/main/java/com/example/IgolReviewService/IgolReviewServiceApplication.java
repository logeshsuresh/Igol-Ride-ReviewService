package com.example.IgolReviewService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class IgolReviewServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(IgolReviewServiceApplication.class, args);
	}

}
