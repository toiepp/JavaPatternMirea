package me.mikholsky.task8.mediator;

public class VK implements Messanger {
	private ConcreteUser1 concreteUser1;
	private ConcreteUser2 concreteUser2;

	public void setConcreteUser1(ConcreteUser1 user) {
		this.concreteUser1 = user;
	}

	public void setConcreteUser2(ConcreteUser2 user) {
		this.concreteUser2 = user;
	}

	@Override
	public void send(String msg, User user) {
		if (user.equals(concreteUser1)) concreteUser2.notify(msg);
		else concreteUser1.notify(msg);
	}
}
