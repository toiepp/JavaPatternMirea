package me.mikholsky.task8.mediator;

public class ConcreteUser2 extends User {
	public ConcreteUser2(Messanger messanger) {
		super(messanger);
	}

	@Override
	public void notify(String msg) {
		System.out.println("User2 received message: " + msg);
	}
}
