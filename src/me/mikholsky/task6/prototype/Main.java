package me.mikholsky.task6.prototype;

public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Cookie cookie = null;
		Cookie prot = new CoconutCookie();
		CookieMachine cm = new CookieMachine(prot);

		for (int i = 0; i < 100; i++) {
			cookie = cm.makeCookie();
			System.out.println(cookie);
		}
	}
}
