package me.mikholsky.task6.abstractFactory;

import me.mikholsky.task6.abstractFactory.products.difficulty.Difficulty;
import me.mikholsky.task6.abstractFactory.products.enemies.Enemy;
import me.mikholsky.task6.abstractFactory.products.loot.Loot;

import java.util.List;

public class Map {
	private final List<Loot> loots;
	private final List<Enemy> enemies;

	public Map(Difficulty difficulty) {
		loots = difficulty.generateLoot();
		enemies = difficulty.generateEnemies();
	}

	public void generateMap() {
		loots.forEach(System.out::println);
		enemies.forEach(System.out::println);
	}
}
