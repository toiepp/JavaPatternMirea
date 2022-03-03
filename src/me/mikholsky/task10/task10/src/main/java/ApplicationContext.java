import classes.Firefly;
import classes.Flashlight;
import classes.Lamp;
import classes.Lighter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class ApplicationContext {
	@Bean
	@Lazy
	public Lighter lamp() {
		return new Lamp();
	}

	@Bean
	@Lazy
	public Lighter flashlight() {
		return new Flashlight();
	}

	@Bean
	@Lazy
	public Lighter firefly(){
		return new Firefly();
	}
}
