import classes.Lighter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(ApplicationContext.class);

		Lighter source;

		source = context.getBean("lamp", Lighter.class);
		source.doLight();

		source = context.getBean("flashlight", Lighter.class);
		source.doLight();

		source = context.getBean("firefly", Lighter.class);
		source.doLight();
	}
}
