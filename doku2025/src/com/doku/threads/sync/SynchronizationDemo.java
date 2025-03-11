package com.doku.threads.sync;

public class SynchronizationDemo {
	
	private static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread one = new Thread(()->{
			for(int i=0; i<10000; i++) {
				increment();
			}
		});
		Thread two = new Thread(()->{
			for(int i=0; i<10000; i++) {
				increment();
			}
		});
		one.start();
		two.start();
		
		one.join();
		two.join();
		
		System.out.println(" counter = " + counter);
	}
	
	private synchronized static void increment() {
		counter++;
	}

}
