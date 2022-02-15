package me.mikholsky.task6.abstractFactory.products.difficulty;

import me.mikholsky.task6.abstractFactory.products.enemies.Enemy;
import me.mikholsky.task6.abstractFactory.products.enemies.Ghost;
import me.mikholsky.task6.abstractFactory.products.enemies.Goblin;
import me.mikholsky.task6.abstractFactory.products.loot.Loot;
import me.mikholsky.task6.abstractFactory.products.loot.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Easy implements Difficulty {
	@Override
	public List<Enemy> generateEnemies() {
		return new ArrayList<>(Arrays.asList(
				new Goblin(),
				new Goblin(),
				new Ghost()
		));
	}

	@Override
	public List<Loot> generateLoot() {
		return new ArrayList<>(List.of(
				new Weapon()
		));
	}
}
