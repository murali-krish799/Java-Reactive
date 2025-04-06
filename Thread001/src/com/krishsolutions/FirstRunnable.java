package com.krishsolutions;

public class FirstRunnable {
int totalCount=0;
	public static void main(String[] args) throws InterruptedException {

		System.out.println("main thread " + Thread.currentThread().getName());

		FirstRunnable firstRunnable = new FirstRunnable();
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {

				for (int i = 50; i <= 10000; i += 50) {
					firstRunnable.returnValue();

				}
			}
		});

		System.out.println(firstRunnable.totalCount);
		thread1.start();
		
		thread1.join();
		System.out.println(firstRunnable.totalCount);

	}

	public synchronized long returnValue() {

		

		totalCount += 50;
		return totalCount;
	}

}
