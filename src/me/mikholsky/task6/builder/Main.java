package me.mikholsky.task6.builder;

public class Main {
	public static void main(String[] args) {
		CarBuilder builder = new ModernCarBuilder();
		AutomotiveEngineer engineer = new AutomotiveEngineer(builder);
		Car car = engineer.manufactureCar();

		if (car != null) {
			System.out.println("Below car delivered: ");
			System.out.println("======================================================================");
			System.out.println(car);
			System.out.println("======================================================================");
		}
	}
}
