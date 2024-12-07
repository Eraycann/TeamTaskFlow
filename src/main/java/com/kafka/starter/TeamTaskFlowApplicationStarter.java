package com.kafka.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan(basePackages = {"com.kafka"})
@EntityScan(basePackages = {"com.kafka"})
@EnableJpaRepositories(basePackages = {"com.kafka"})
@SpringBootApplication
public class TeamTaskFlowApplicationStarter {

	public static void main(String[] args) {
		SpringApplication.run(TeamTaskFlowApplicationStarter.class, args);
	}

}
