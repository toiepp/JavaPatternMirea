package me.mikholsky.task3;

// Вариант 4

import java.util.*;

public class Main {
	private static void task1() {
		// Пункт 1

//		Set<Integer> testSet = new SyncSet<>();
		Set<Integer> testSet = new HashSet<>();

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

		System.out.println(testSet.size());
	}

	private static void task2() {
//		Map<Integer, Integer> testMap = new HashMap<>();
		Map<Integer, Integer> testMap = Collections.synchronizedMap(new HashMap<>());
//		Map<Integer, Integer> testMap = new LockMap<>();

		var t1 = new Thread(() -> {
			for (int i = 0; i < 1000; ++i) {
				testMap.put(i, i * 10);
			}
		});

		var t2 = new Thread(() -> {
			for (int i = 0; i < 1000; ++i) {
				testMap.remove(i, i * 10);
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

		System.out.println(testMap.size());
	}

	public static void main(String[] args) {
		task2();
	}
}
