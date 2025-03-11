package com.pattern.prototype;

public class Dog implements Animal {
	@Override
	public Animal clone() {
		Dog cloned = null;
		try {
			cloned = (Dog) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	
	public String toString() {
		return "this is a dog";
	}
	
}
