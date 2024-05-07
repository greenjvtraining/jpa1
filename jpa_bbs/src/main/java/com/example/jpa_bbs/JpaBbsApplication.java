package com.example.jpa_bbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JpaBbsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaBbsApplication.class, args);
	}

}
