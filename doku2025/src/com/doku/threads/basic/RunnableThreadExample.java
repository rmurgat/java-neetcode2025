package com.doku.threads.basic;

public class RunnableThreadExample {

	public static void main(String[] args) {
		Thread one = new Thread(new ThreadOne());
		Thread two = new Thread(new ThreadTwo());
		Thread three = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0; i<20; i++) {
					System.out.println("Thread III: " + i + ",");
				}
			}
		});
		Thread four = new Thread(()-> {
			for(int i=0; i<20; i++) {
				System.out.println("Thread IV: " + i + ",");
			}
		});		
		one.start();
		two.start();
		three.start();
		four.start();
	}
}

class ThreadOne implements Runnable {
	@Override
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("Thread I: " + i + ",");
		}
	}
}

class ThreadTwo implements Runnable {
	@Override	
	public void run() {
		for(int i=0; i<20; i++) {
			System.out.println("Thread II: " + i + ",");
		}
	}
}