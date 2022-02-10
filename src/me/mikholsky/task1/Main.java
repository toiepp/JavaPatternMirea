package me.mikholsky.task1;

import java.math.BigInteger;
import java.util.function.BiFunction;

// Вариант 4

public class Main {
	public static void main(String[] args) {
		BiFunction<Integer, Integer, Integer> nod = (n1, n2) ->
				new BigInteger(String.valueOf(n1))
						.gcd(new BigInteger(String.valueOf(n2)))
						.intValue();

		System.out.println(nod.apply(11, 33));
	}
}
