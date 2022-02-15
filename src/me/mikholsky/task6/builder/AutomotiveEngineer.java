package me.mikholsky.task6.builder;

public record AutomotiveEngineer(CarBuilder builder) {
	public AutomotiveEngineer(CarBuilder builder) {
		this.builder = builder;
		if (this.builder == null) {
			throw new IllegalArgumentException("Automotive Engineer can't work without Car Builder!");
		}
	}

	public Car manufactureCar() {
		return builder.fixChassis().fixBody().paint().fixInterior().build();
	}
}
