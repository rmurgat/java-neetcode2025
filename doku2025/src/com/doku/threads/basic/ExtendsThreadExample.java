package com.doku.threads.basic;

public class ExtendsThreadExample {

	public static void main(String[] args) {
		Thread one = new Thread1();
		Thread two = new Thread2();
		
		one.start();
		two.start();
		
	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<40; i++) {
			System.out.println("Thread 1: " + i);
		}
	}
}

class Thread2 extends Thread {
	@Override
	public void run() {
		for(int i=0; i<40; i++) {
			System.out.println("Thread 2: " + i);
		}
	}
}
