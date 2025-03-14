package com.doku.threads.sync;

public class LockWithCustomObjects {
	
	private static int counter1 = 0;
	private static int counter2 = 0;

	public static void main(String[] args) {
		Thread one = new Thread(()->{
			for(int i=0; i<10000; i++)
				increment1();
		});
		Thread two =new Thread(()->{
			for(int i=0; i<10000; i++)
				increment2();
		});

		one.start();
		two.start();
		try {
			one.join();
			two.join();
			
		} catch(InterruptedException e) {
			throw new RuntimeException(e);
		}
		System.out.println("Answer counter1: " + counter1 + ", counter2: "+ counter2);
	}
	
	private static Object lock1 = new Object();
	private static Object lock2 = new Object();
	public static void increment1() {
		synchronized(lock1) {
			counter1++;
		}
	}
	public static void increment2() {
		synchronized(lock2) {
			counter2++;
		}
	} 

}
