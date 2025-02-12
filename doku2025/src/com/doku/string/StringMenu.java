package com.doku.string;

import java.util.Scanner;

public class StringMenu {
	
	public static void doku_palindrome() {
		StringLib lib = new StringLib();
		System.out.println(" [ isPalindrome ]");
		System.out.println(" Answer 1:" + lib.isPalindrome("aba"));
		System.out.println(" Answer 2:" + lib.isPalindrome("aa"));
		System.out.println(" Answer 3:" + lib.isPalindrome("a"));
		System.out.println(" Answer 4:" + lib.isPalindrome(""));
		System.out.println(" Answer 5:" + lib.isPalindrome("rocolino"));
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ MAIN MENU ]");
		System.out.println(" 1. palindrome");
		System.out.print("[write option:] ");
		int opc = scan.nextInt();
		switch(opc) {
			case 1: doku_palindrome();
					break;
			default: System.out.println("[error] option not allowed");
		}
		scan.close();
	}

}
