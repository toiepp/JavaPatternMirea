package me.mikholsky.task8.mediator;

public class ConcreteUser1 extends User {
	public ConcreteUser1(Messanger messanger) {
		super(messanger);
	}

	@Override
	public void notify(String msg) {
		System.out.println("User1 received message: " + msg);
	}
}
