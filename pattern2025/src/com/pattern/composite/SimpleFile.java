package com.pattern.composite;

public class SimpleFile extends File {

	public SimpleFile(String name) {
		this.name = name;
	}
	
	@Override
	public void showInfo() {
		System.out.println(identado.toString() + "-Simple File: " + getName());
	}

}
