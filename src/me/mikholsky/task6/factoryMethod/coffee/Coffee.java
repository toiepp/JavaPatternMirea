package me.mikholsky.task6.factoryMethod.coffee;

public abstract class Coffee {
	public void grindBeans() {
		System.out.println("Grinding beans");
	}

	public abstract void brewCoffee();

	public void pourIntoCup() {
		System.out.println("Pouring coffee into cup");
	}
}
