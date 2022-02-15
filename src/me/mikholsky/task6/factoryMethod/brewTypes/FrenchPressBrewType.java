package me.mikholsky.task6.factoryMethod.brewTypes;

import me.mikholsky.task6.factoryMethod.coffee.Coffee;
import me.mikholsky.task6.factoryMethod.coffee.FrenchPressCoffee;

public class FrenchPressBrewType extends BrewType {
	@Override
	public Coffee brewCoffee() {
		return new FrenchPressCoffee();
	}
}
