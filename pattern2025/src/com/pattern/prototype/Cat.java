package com.pattern.prototype;

public class Cat implements Animal {
	
	@Override
	public Animal clone() {
		Cat cloned = null;
		try {
			cloned = (Cat) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return cloned;
	}
	
	public String toString() {
		return "this is a cat";
	}

}
