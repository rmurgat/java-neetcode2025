package com.pattern.prototype;

public class AnimalCloneFactory {
	public Animal getClone(Animal toclone) {
		return toclone.clone();
	}
}
