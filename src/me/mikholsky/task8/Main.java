package me.mikholsky.task8;

import me.mikholsky.task8.mediator.*;
import me.mikholsky.task8.memento.TextEditor;
import me.mikholsky.task8.memento.TextWindow;

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


		System.out.println();
		System.out.println();


		// Паттерн Снимок
		TextEditor textEditor = new TextEditor(new TextWindow());
		textEditor.write("The Memento Design Pattern\n");
		textEditor.write("How to implement it in Java?\n");
		textEditor.hitSave();

		textEditor.write("Buy milk and eggs before coming home\n");

		textEditor.hitUndo();

		System.out.println(textEditor.print());
	}
}
