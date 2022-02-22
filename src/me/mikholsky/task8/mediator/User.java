package me.mikholsky.task8.mediator;

public abstract class User {
	protected Messanger messanger;

	public User(Messanger messanger) {
		this.messanger = messanger;
	}

	public abstract void notify(String msg);
}
