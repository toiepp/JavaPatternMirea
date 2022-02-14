package me.mikholsky.task6.factoryMethod.coffee;

import me.mikholsky.task6.factoryMethod.enums.CoffeeBrewType;
import me.mikholsky.task6.factoryMethod.enums.CoffeeType;

public class Coffee {
	private final CoffeeType coffeeType;
	private final CoffeeBrewType coffeeBrewType;

	public Coffee(CoffeeType type, CoffeeBrewType brewType) {
		this.coffeeType = type;
		this.coffeeBrewType = brewType;
	}

	@Override
	public String toString() {
		return "Coffee{" +
				coffeeType + ", " +
				coffeeBrewType +
				'}';
	}
}
