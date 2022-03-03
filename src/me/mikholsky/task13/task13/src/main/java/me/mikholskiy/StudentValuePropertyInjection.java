package me.mikholskiy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentValuePropertyInjection {
	@Value("${student.name}")
	private String name;
	@Value("${student.last_name}")
	private String lastName;
	@Value("${student.group}")
	private String group;

	@Override
	public String toString() {
		return "StudentValuePropertyInjection{" +
				"name='" + name + '\'' +
				", lastName='" + lastName + '\'' +
				", group='" + group + '\'' +
				'}';
	}
}
