package classes;

public class Flashlight implements Lighter {
	@Override
	public void doLight() {
		System.out.println("Flashlight emits light");
	}
}
