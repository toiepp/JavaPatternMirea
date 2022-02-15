package me.mikholsky.task6.abstractFactory.products.difficulty;

import me.mikholsky.task6.abstractFactory.products.enemies.Enemy;
import me.mikholsky.task6.abstractFactory.products.loot.Loot;

import java.util.List;

public interface Difficulty {
	List<Enemy> generateEnemies();

	List<Loot> generateLoot();
}
