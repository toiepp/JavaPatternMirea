package me.mikholsky.task7.decorator;

import java.util.LinkedHashSet;
import java.util.Set;

public class CoffeeBean implements Coffee {
	private final Coffee component;

	public CoffeeBean() {
		component = null;
	}

	public CoffeeBean(Coffee component) {
		this.component = component;
	}

	@Override
	public Set<Coffee> getComposition() {
		Set<Coffee> set = new LinkedHashSet<>();
		if (component != null) {
			set.addAll(component.getComposition());
		}
		set.add(this);
		return set;
	}
}
