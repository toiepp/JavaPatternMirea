package me.mikholsky.task5;

public class SingletonOne {
	private SingletonOne() {
	}

	public static final SingletonOne instance = new SingletonOne();
}
