package com.doku.java.core;

import java.util.ArrayList;
import java.util.List;

interface testInterface {
	final int a = 1;
	default void display() {
		System.out.println("default display() method");
	}
	
	default void sayhi() {
		System.out.println("Say hi to all world!");
	}
	default void saysomething(String something, String two) {
		System.out.println("saying something: " + something + ", two: " + two);
	}
}

class Interval {
	public int start;
	public int end;
	public Interval() {
		super();
	}
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}

public class FinalClass implements testInterface {
	
	public static void main(String[] args) {
		List<Interval> l = new ArrayList<>();
		FinalClass app = new FinalClass();
		app.display();
		app.sayhi();
		
		l.add(new Interval(1,2));
		l.add(new Interval(2,3));
		
		l.forEach(i-> app.saysomething(String.valueOf(i.start),String.valueOf(i.end)));
 	}

}
