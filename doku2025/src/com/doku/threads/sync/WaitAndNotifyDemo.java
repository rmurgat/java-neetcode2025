package com.doku.threads.sync;

public class WaitAndNotifyDemo {

	public static void main(String[] args) {
		Thread one = new Thread(()->{
			try {
				one();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		Thread two = new Thread(()->{
			try {
				two();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		one.start();
		two.start();
	}
	
	private static Object LOCK = new Object();
	private static void one() throws InterruptedException {
		synchronized (LOCK) {
			System.out.println("Hello from method one...");
			LOCK.wait();
			System.out.println("Back again in the method one");
		}
	}
	private static void two() throws InterruptedException {
		synchronized (LOCK) {
			System.out.println("Hello from method two...");
			LOCK.notify();
			System.out.println("Hello from method two even after notify...");
		}
	}	

}
