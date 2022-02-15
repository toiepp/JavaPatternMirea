package me.mikholsky.task6.abstractFactory.products.difficulty;

import me.mikholsky.task6.abstractFactory.products.enemies.Enemy;
import me.mikholsky.task6.abstractFactory.products.enemies.Ghost;
import me.mikholsky.task6.abstractFactory.products.enemies.Golem;
import me.mikholsky.task6.abstractFactory.products.loot.Artifact;
import me.mikholsky.task6.abstractFactory.products.loot.Loot;
import me.mikholsky.task6.abstractFactory.products.loot.Weapon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Middle implements Difficulty {
	@Override
	public List<Enemy> generateEnemies() {
		return new ArrayList<>(Arrays.asList(
				new Ghost(),
				new Ghost(),
				new Golem()
		));
	}

	@Override
	public List<Loot> generateLoot() {
		return new ArrayList<>(Arrays.asList(
				new Weapon(),
				new Artifact()
		));
	}
}
