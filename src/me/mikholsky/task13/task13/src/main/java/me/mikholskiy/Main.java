import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		var context = new AnnotationConfigApplicationContext(AppContext.class);

		System.out.println(context.getBean(Student.class));
	}
}
