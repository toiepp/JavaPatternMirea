package me.mikholskiy;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(AppContext.class);

		System.out.println(context.getBean(StudentValuePropertyInjection.class));

		System.out.println(context.getBean(StudentEnvironmentPropertyInjection.class));
	}
}
