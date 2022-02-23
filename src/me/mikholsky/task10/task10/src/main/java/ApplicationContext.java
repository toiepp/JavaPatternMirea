import classes.Firefly;
import classes.Flashlight;
import classes.Lamp;
import classes.Lighter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContext {
	@Bean
	public Lighter lamp() {
		return new Lamp();
	}

	@Bean
	public Lighter flashlight() {
		return new Flashlight();
	}

	@Bean
	public Lighter firefly(){
		return new Firefly();
	}
}
