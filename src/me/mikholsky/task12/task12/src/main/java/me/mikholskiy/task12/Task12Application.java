package me.mikholskiy.task12;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:application.properties"})
public class Task12Application implements CommandLineRunner, ApplicationContextAware {
	private ApplicationContext applicationContext;

	public static void main(String[] args) {
		SpringApplication.run(Task12Application.class, args);
	}

	@Override
	public void run(String... args) {
		applicationContext.getBean(HashGen.class, args[0], args[1]);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
