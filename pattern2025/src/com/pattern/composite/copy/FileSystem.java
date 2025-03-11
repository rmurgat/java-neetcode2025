package com.pattern.composite.copy;

public class FileSystem {
	private File root;
	
	public FileSystem(File root) {
		this.root = root;
	}
	public void printFiles() {
		root.showInfo();
	}
}
