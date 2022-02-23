package me.mikholsky.task4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;

public class Main {
	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.S");
	private final int COUNT = 5;

	Main() {
		CountDownLatch cdl1 = new CountDownLatch(COUNT);
		CountDownLatch cdl2 = new CountDownLatch(COUNT);
		CountDownLatch cdl3 = new CountDownLatch(COUNT);
		CountDownLatch cdl4 = new CountDownLatch(COUNT);

		MyExecutorService executor = new MyExecutorService(Executors.newFixedThreadPool(2));

		System.out.println("Запуск потоков");
		executor.execute(new MyThread(cdl1, "Thread.1"));
		executor.execute(new MyThread(cdl2, "Thread.2"));
		executor.execute(new MyThread(cdl3, "Thread.3"));
		executor.execute(new MyThread(cdl4, "Thread.4"));

		try {
			cdl1.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
		} catch (InterruptedException ignored) {
		}

		executor.shutdown();
		System.out.println("Завершение потоков");
	}

	void printMessage(final String templ) {
		String text = sdf.format(new Date()) + " : " + templ;
		System.out.println(text);
	}

	class MyThread implements Runnable {
		String name;
		CountDownLatch latch;

		MyThread(CountDownLatch c, String n) {
			latch = c;
			name = n;
			new Thread(this);
		}

		public void run() {
			try {
				for (int i = 0; i < COUNT; i++) {
					printMessage(name + " - " + i);
					latch.countDown();
					Thread.sleep((long) (Math.random() * 1500));
				}
				printMessage(name + " completed");
			} catch (InterruptedException ignored) {
			}
		}
	}

	public static void main(String[] args) {
		new Main();
	}
}
