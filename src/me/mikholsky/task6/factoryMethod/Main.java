package me.mikholsky.task6.factoryMethod;

import me.mikholsky.task6.factoryMethod.baristas.AeropressBarista;
import me.mikholsky.task6.factoryMethod.baristas.Barista;
import me.mikholsky.task6.factoryMethod.coffee.Coffee;
import me.mikholsky.task6.factoryMethod.enums.CoffeeType;

public class Main {
	public static void main(String[] args) {
		Barista barista = new AeropressBarista();

		Coffee coffee = barista.brew(CoffeeType.ESPRESSO);

		System.out.println(coffee);
	}
}
