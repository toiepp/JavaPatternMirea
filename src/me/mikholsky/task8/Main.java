package me.mikholsky.task8;

import me.mikholsky.task8.mediator.*;

/**
 * Вариан 4 */

public class Main {
	public static void main(String[] args) {
		// Паттерн Посредник
		VK vk = new VK();
		ConcreteUser1 u1 = new ConcreteUser1(vk);
		ConcreteUser2 u2 = new ConcreteUser2(vk);

		vk.setConcreteUser1(u1);
		vk.setConcreteUser2(u2);

		u1.notify("Hello there!");
		u2.notify("General Kenobi!");

		// Паттерн Снимок


	}
}
