package com.pattern.composite;

public class Main {

	public static void main(String[] args) {
		File root = new Directory("root");
        File home = new Directory("home");
        File opt  = new Directory("opt");
        File usr = new Directory("usr");		
		
        root.add(home);
        root.add(opt);
        root.add(usr);
		
        usr.add(new SimpleFile("bin.txt"));
        usr.add(new SimpleFile("lib.txt"));
        
        opt.add(new SimpleFile("google.txt"));
        opt.add(new SimpleFile("idea.txt"));
        opt.add(new SimpleFile("spotify.txt"));
        
        home.add(new SimpleFile("ruben.txt"));
		
		FileSystem fs = new FileSystem(root);
		fs.printFiles();

	}

}
