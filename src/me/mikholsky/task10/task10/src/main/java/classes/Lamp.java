package classes;

public class Lamp implements Lighter {
	@Override
	public void doLight() {
		System.out.println("Lamp emits light");
	}
}
