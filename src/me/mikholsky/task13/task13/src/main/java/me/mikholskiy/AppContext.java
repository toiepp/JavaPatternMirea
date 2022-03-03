import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.beans.ConstructorProperties;

@Configuration
@ComponentScan({"me.mikholskiy"})
@PropertySource({"application.yml"})
public class AppContext {
	@Bean
	public Student student(
			@Value("${student.name}") String name,
			@Value("${student.last_name}") String last_name,
			@Value("${student.group}") String group) {
		return new Student(name, last_name, group);
	}
}
