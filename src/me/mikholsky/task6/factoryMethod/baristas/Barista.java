package me.mikholsky.task6.factoryMethod.baristas;

import me.mikholsky.task6.factoryMethod.coffee.Coffee;
import me.mikholsky.task6.factoryMethod.enums.CoffeeType;

public interface Barista {
	Coffee brew(CoffeeType coffeeType);
}
