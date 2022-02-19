package me.mikholsky.task3;

// Вариант 4

import java.util.*;
import java.util.stream.IntStream;

public class Main {
	private static boolean setKeepsOrder(Set<Integer> set) {
		Integer[] arr = set.toArray(new Integer[0]);
		for (int i = 0; i < arr.length - 1; ++i) {
			if (arr[i] > arr[i + 1]) return false;
		}
		return true;
	}

	private static void task1() throws InterruptedException {
		Set<Integer> testSet = new SyncSet<>(new LinkedHashSet<>());

		Thread t1 = new Thread(() -> IntStream.range(0, 10).forEach(testSet::add));

		Thread t2 = new Thread(() -> IntStream.range(10, 20).forEach(testSet::add));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(setKeepsOrder(testSet));
	}

	private static void task2() throws InterruptedException {
//		Map<Integer, Integer> testMap = new HashMap<>();
		Map<Integer, Integer> testMap = new LockMap<>(new LinkedHashMap<>());

		Thread t1 = new Thread(() -> IntStream.range(0, 10).forEach(i -> testMap.put(i, i * 10)));

		Thread t2 = new Thread(() -> IntStream.range(10, 20).forEach(i -> testMap.put(i, i * 10)));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		for (Map.Entry<Integer, Integer> el : testMap.entrySet()) {
			System.out.println(el.getKey() + ": " + el.getValue());
		}
	}

	public static void main(String[] args) {
		IntStream.range(0, 1000)
				.forEach(el -> {
					System.out.print(el + ": ");
					try {
						task1();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
	}
}
