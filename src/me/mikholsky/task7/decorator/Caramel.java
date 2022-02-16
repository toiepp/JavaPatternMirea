package me.mikholsky.task7.decorator;

import java.util.LinkedHashSet;
import java.util.Set;

public class Caramel implements Coffee {
	private final Coffee component;

	public Caramel() {
		component = null;
	}

	public Caramel(Coffee component) {
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
