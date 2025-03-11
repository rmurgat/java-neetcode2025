package com.pattern.singleton;

public class LazySingleton {
	private static LazySingleton instance = null;
	public LazySingleton() {}
	public static LazySingleton getInstance() {
		if(instance==null) 
			synchronized(LazySingleton.class) {
				if(instance == null) {
					instance = new LazySingleton();
				}
			}
		return instance; 
	}
}
