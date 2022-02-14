package me.mikholsky.task5;

public class Main {
	public static void main(String[] args) {
		SingletonOne s1 = SingletonOne.instance;
		SingletonOne s2 = SingletonOne.instance;

		System.out.println(s1);
		System.out.println(s2);

		SingletonTwo s3 = SingletonTwo.INSTANCE;
		SingletonTwo s4 = SingletonTwo.INSTANCE;
		System.out.println(s3);
		System.out.println(s4);

		SingletonThree s5 = SingletonThree.getInstance();
		SingletonThree s6 = SingletonThree.getInstance();

		System.out.println(s5);
		System.out.println(s6);
	}
}
