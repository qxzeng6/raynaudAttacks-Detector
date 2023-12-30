package com.raynaud.raynaudAttacksDetector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.sql.*;

@SpringBootApplication
//@EnableJpaAuditing
public class RaynaudAttacksDetectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RaynaudAttacksDetectorApplication.class, args);
	}

}
