package me.mikholsky.task6.abstractFactory;

import me.mikholsky.task6.abstractFactory.products.difficulty.Difficulty;
import me.mikholsky.task6.abstractFactory.products.difficulty.Easy;
import me.mikholsky.task6.abstractFactory.products.difficulty.Hard;

public class Main {
	public static void main(String[] args) {
		Difficulty difficulty = new Easy();
		Map map = new Map(difficulty);
		map.generateMap();

		System.out.println();

		difficulty = new Hard();
		map = new Map(difficulty);
		map.generateMap();
	}
}
