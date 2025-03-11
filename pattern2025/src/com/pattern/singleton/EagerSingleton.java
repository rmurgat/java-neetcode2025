package com.pattern.singleton;

public class EagerSingleton {
	private static int icounter = 0;
	private String name = "";
	private static EagerSingleton instance = new EagerSingleton();
	private EagerSingleton() { }
	public static EagerSingleton getInstance() {
		icounter = icounter + 1;
		return instance;
	}
	public static int getCounter() {
		return icounter;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "EagerSingleton [name=" + name + "]";
	}
	
}