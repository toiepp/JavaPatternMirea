package me.mikholsky.task6.prototype;

public class Cookie implements Cloneable {
	@Override
	public Cookie clone() throws CloneNotSupportedException {
		return ((Cookie) super.clone());
	}
}
