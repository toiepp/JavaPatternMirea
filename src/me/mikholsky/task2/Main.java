package me.mikholsky.task2;

// Вариант 4

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
	public static void main(String[] args) {
		List<Human> list = new ArrayList<>(Arrays.asList(
				new Human(22, "Ivan", "Mikholskiy", LocalDate.of(1980, 2, 28), 50),
				new Human(30, "John", "Brown", LocalDate.of(2000, 1, 31), 130),
				new Human(12, "Jack", "Malkovich", LocalDate.of(1967, 11, 12), 80),
				new Human(10, "Michael", "White", LocalDate.of(2005, 5, 20), 75)
		));

		Comparator<Human> bySecondLetterOfName = Comparator.comparingInt(h -> h.getFirstName().charAt(1));
		Comparator<Human> byMulOfAgeAndWeight = Comparator.comparingInt(h -> h.getWeight() * h.getAge());

		List<Human> changed1 = list.stream()
				.sorted(bySecondLetterOfName)
				.collect(Collectors.toList());
		changed1.forEach(System.out::println);
		System.out.println();

		List<Human> changed2 = list.stream()
				.filter(human -> human.getWeight() % 10 == 0)
				.collect(Collectors.toList());
		changed2.forEach(System.out::println);
		System.out.println();

		List<Human> changed3 = list.stream()
				.sorted(byMulOfAgeAndWeight)
				.collect(Collectors.toList());
		changed3.forEach(System.out::println);
		System.out.println();

		int totalWeight = list.stream()
				.map(Human::getWeight)
				.reduce(1, (w1, w2) -> w1 * w2);
		System.out.println(totalWeight);

		int mul = 1;
		for (Human h : list) {
			mul *= h.getWeight();
		}
		System.out.println(mul);
	}
}
