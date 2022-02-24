package me.mikholskiy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Main {
	private final Hasher hasher;

	@Autowired
	public Main(Hasher hasher) {
		this.hasher = hasher;
	}

	public void run() {
		hasher.info();
	}

	public static void main(String[] args) {
		new Main(new Hasher(args[0], args[1])).run();
	}
}
