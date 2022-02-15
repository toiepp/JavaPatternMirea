package me.mikholsky.task6.builder;

public interface CarBuilder {
	// Этап 1
	CarBuilder fixChassis();

	// Этап 2
	CarBuilder fixBody();

	// Этап 3
	CarBuilder paint();

	// Этап 4
	CarBuilder fixInterior();

	// Выпуск автомобиля
	Car build();
}
