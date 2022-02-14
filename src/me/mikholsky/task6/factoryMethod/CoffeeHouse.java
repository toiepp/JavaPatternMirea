package me.mikholsky.task6.factoryMethod;

import me.mikholsky.task6.factoryMethod.baristas.Barista;
import me.mikholsky.task6.factoryMethod.coffee.Coffee;
import me.mikholsky.task6.factoryMethod.enums.CoffeeType;

public record CoffeeHouse(Barista barista) {
	public Coffee makeAnOrder(CoffeeType coffeeType) {
		return barista.brew(coffeeType);
	}
}
