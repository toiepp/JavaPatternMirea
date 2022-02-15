package me.mikholsky.task6.factoryMethod;

import me.mikholsky.task6.factoryMethod.brewTypes.BrewType;
import me.mikholsky.task6.factoryMethod.brewTypes.MochaBrewType;
import me.mikholsky.task6.factoryMethod.coffee.Coffee;

public class Main {
	public static void main(String[] args) {
		/* Фабрика */
		BrewType mocha = new MochaBrewType();
		/* Продукт */
		Coffee coffee = mocha./*фабричный метод*/brewCoffee();
		System.out.println(coffee);
	}
}
