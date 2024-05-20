package com.ProjectSC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ProjectScApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectScApplication.class, args);
	}

}
