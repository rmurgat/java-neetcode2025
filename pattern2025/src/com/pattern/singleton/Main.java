package com.pattern.singleton;

import java.util.Scanner;

public class Main {
	
	public static void testingEagersingleton() {
		EagerSingleton esingleton1 = EagerSingleton.getInstance();
		esingleton1.setName("the_singleton_name: " + EagerSingleton.getCounter());
		EagerSingleton esingleton2 = EagerSingleton.getInstance();
		esingleton1.setName("the_singleton_name: " + EagerSingleton.getCounter());
		System.out.println("Testing Eager Singleton 1 " + esingleton1 + ", " + esingleton2);
	}
	
	public static void testingLazySingleton() {
		LazySingleton lsingleton1 = LazySingleton.getInstance();
		LazySingleton lsingleton2 = LazySingleton.getInstance();
		System.out.println("Testing Lazy Singleton 1 " + lsingleton1 + ", " + lsingleton2);
	}
	
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println(" [ DESIGN PATTERN MENU ] ");
		System.out.println(" 1. Eager Singleton ");
		System.out.println(" 2. Lazy Singleton ");
		int opc = scan.nextInt();
		switch(opc) {
			case 1: 
				testingEagersingleton();
				break;
			case 2: 
				testingLazySingleton();
				break;
			default:
				System.out.println("***option not allowed");
		}
		scan.close();
	}
}
