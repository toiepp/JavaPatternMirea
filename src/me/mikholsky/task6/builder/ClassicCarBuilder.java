package me.mikholsky.task6.builder;

public class ClassicCarBuilder implements CarBuilder {
	private String chassin;
	private String body;
	private String paint;
	private String interior;

	public ClassicCarBuilder() { super(); }

	@Override
	public CarBuilder fixChassis() {
		return null;
	}

	@Override
	public CarBuilder fixBody() {
		return null;
	}

	@Override
	public CarBuilder paint() {
		return null;
	}

	@Override
	public CarBuilder fixInterior() {
		return null;
	}

	@Override
	public Car build() {
		return null;
	}
}
