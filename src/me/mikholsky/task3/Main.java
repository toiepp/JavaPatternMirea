package me.mikholsky.task3;

// Вариант 4


import java.util.HashSet;
import java.util.Set;

public class Main {
	private static <T> void print(Set<T> set) {
		set.forEach(el -> System.out.print(el + " "));
		System.out.println();
	}

	public static void main(String[] args) {
		Set<Integer> testSet = new SyncSet<>();
//		Set<Integer> testSet = new HashSet<>();

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 1000; ++i) {
				testSet.add(i * 10);
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 1000; ++i) {
				testSet.remove(i * 10);
			}
		});

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		testSet.forEach(el -> System.out.print(el + " "));
	}
}
