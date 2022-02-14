package me.mikholsky.task6.factoryMethod.baristas;

import me.mikholsky.task6.factoryMethod.coffee.Coffee;
import me.mikholsky.task6.factoryMethod.enums.CoffeeBrewType;
import me.mikholsky.task6.factoryMethod.enums.CoffeeType;

public class FrenchPressBarista implements Barista {
	@Override
	public Coffee brew(CoffeeType coffeeType) {
		Coffee coffee;
		switch (coffeeType) {
			case ESPRESSO -> coffee = new Coffee(CoffeeType.ESPRESSO, CoffeeBrewType.FRENCH_PRESS);
			case LATTE -> coffee = new Coffee(CoffeeType.LATTE, CoffeeBrewType.FRENCH_PRESS);
			case CAPPUCCINO -> coffee = new Coffee(CoffeeType.CAPPUCCINO, CoffeeBrewType.FRENCH_PRESS);
			default ->  coffee = null;
		}
		return coffee;
	}
}
