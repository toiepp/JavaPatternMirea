package me.mikholsky.task3;

// Вариант 4

import com.sun.source.tree.Tree;

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
		Set<Integer> testSet = new SyncSet<>(new HashSet<>());

		Thread t1 = new Thread(() -> IntStream.range(0, 500).forEach(testSet::add));

		Thread t2 = new Thread(() -> IntStream.range(500, 1000).forEach(testSet::add));

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println(setKeepsOrder(testSet));
	}

	private static void task2() throws InterruptedException {
//		Map<Integer, Integer> map = new HashMap<>();
		Map<Map.Entry<Integer, Integer>, Boolean> seats = new LockMap<>(new HashMap<>());

	}

	public static void main(String[] args) {
		IntStream.range(0, 1000)
				.forEach(el -> {
					System.out.print(el + ": ");
					try {
						task2();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				});
	}
}
