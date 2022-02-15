package me.mikholsky.task6.prototype;

public class CookieMachine {
	private final Cookie cookie;

	public CookieMachine(Cookie cookie) {
		this.cookie = cookie;
	}

	public Cookie makeCookie() throws CloneNotSupportedException {
		return ((Cookie) this.cookie.clone());
	}
}
