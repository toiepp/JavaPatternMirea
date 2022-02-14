package me.mikholsky.task5;

public class SingletonThree {
	private static SingletonThree instance;

	private SingletonThree() {}

	public static synchronized SingletonThree getInstance() {
		if (instance == null) {
			instance = new SingletonThree();
		}
		return instance;
	}
}
