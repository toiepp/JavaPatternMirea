package me.mikholsky.task6.factoryMethod.baristas;

import me.mikholsky.task6.factoryMethod.coffee.Coffee;
import me.mikholsky.task6.factoryMethod.enums.CoffeeBrewType;
import me.mikholsky.task6.factoryMethod.enums.CoffeeType;

public class AeropressBarista implements Barista {
	@Override
	public Coffee brew(CoffeeType coffeeType) {
		Coffee coffee;
		switch (coffeeType) {
			case ESPRESSO -> coffee = new Coffee(CoffeeType.ESPRESSO, CoffeeBrewType.AEROPRESS);
			case LATTE -> coffee = new Coffee(CoffeeType.LATTE, CoffeeBrewType.AEROPRESS);
			case CAPPUCCINO -> coffee = new Coffee(CoffeeType.CAPPUCCINO, CoffeeBrewType.AEROPRESS);
			default ->  coffee = null;
		}
		return coffee;
	}
}
