package me.mikholskiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class StudentEnvironmentPropertyInjection {
	private String name;
	private String lastName;
	private String group;
	private Environment environment;

	@Autowired
	public StudentEnvironmentPropertyInjection(Environment environment) {
		name = environment.getProperty("student.name", String.class);
		lastName = environment.getProperty("student.last_name", String.class);
		group = environment.getProperty("student.group", String.class);
	}

	@Override
	public String toString() {
		return "StudentEnvironmentPropertyInjection{" +
				"name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}
