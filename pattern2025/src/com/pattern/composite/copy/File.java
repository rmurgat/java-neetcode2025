package com.pattern.composite.copy;

public abstract class File {
	protected String name;
	protected static StringBuffer identado = new StringBuffer();
	
	public void add(File component) {
		throw new UnsupportedOperationException();
	}
	public void remove(File component) {
		throw new UnsupportedOperationException();
	}
	public String getName() {
		return this.name;
	}
	public void showInfo() {
		throw new UnsupportedOperationException();
	}
	
}
