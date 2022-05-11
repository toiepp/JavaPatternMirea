package me.mikholskiy.task18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Task18Application {
	public static void main(String[] args) {
		SpringApplication.run(Task18Application.class, args);
	}
}
