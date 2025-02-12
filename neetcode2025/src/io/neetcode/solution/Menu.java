package io.neetcode.solution;

import java.util.Arrays;
import java.util.Scanner;

import io.neetcode.solution.code.ArrayBundle;
import io.neetcode.solution.code.IntervalBundle;
import io.neetcode.solution.code.StringBundle;

public class Menu {
	
	static public void neetcode_longpalindrome() {
		StringBundle lib = new StringBundle();
		System.out.println(" [ Longest Palindrome Substring ] ");
		System.out.println(" Answer 1: " + lib.longestPalindrome("ababd"));
		System.out.println(" Answer 2: " + lib.longestPalindrome("abbc"));
	}
	static public void neetcode_palindromicsubstr() {
		StringBundle lib = new StringBundle();
		System.out.println(" [ Palindromic Substring ] ");
		System.out.println(" Answer 1: " + lib.countSubstrings("abc"));
		System.out.println(" Answer 2: " + lib.countSubstrings("aaa"));
	}
	
	static public void neetcode_decodeways() {
		StringBundle lib = new StringBundle();
		System.out.println(" [ Decode Ways ]");
		System.out.println(" Answer 1: " + lib.numDecodings("12"));
		System.out.println(" Answer 2: " + lib.numDecodings("06"));
		System.out.println(" Answer 3: " + lib.numDecodings("12134"));
	}
	
	static public void neetcode_coinchange() {
		ArrayBundle lib = new ArrayBundle();
		System.out.println(" [ Con Change ] ");
		System.out.println(" Answer 1 (out-time):" + lib.coinChange_1(new int[]{1,5,10},12));
		System.out.println(" Answer 2 (out-time):" + lib.coinChange_1(new int[]{1},12));
		System.out.println(" Answer 3 (out-time):" + lib.coinChange_1(new int[]{2},3));
		System.out.println(" Answer 4 (out-time):" + lib.coinChange_2(new int[]{1,2,5},11));
	}
	
	static public void neetcode_insertinterval() {
		IntervalBundle lib = new IntervalBundle();
		
		// result 1
		int[][] result1 = lib.insert(new int[][] { {1,3}, {6,9} }, new int[] { 2, 5 });
		System.out.print(" Answer 1: ");
		for(int[] row: result1 ) 
			System.out.print("["+row[0] +","+ row[1]+"], ");
		
		// result 1
		int[][] result2 = lib.insert(new int[][] {{1,2},{3,5},{9,10}}, new int[] { 6, 7 });
		System.out.print("\n Answer 2: ");
		for(int[] row: result2 ) 
			System.out.print("["+row[0] +","+ row[1]+"], ");

		// result 1
		int[][] result3 = lib.insert(new int[][] {{1,3},{4,6}}, new int[] {2,5});		
		System.out.print("\n Answer 3: ");
		for(int[] row: result3 ) 
			System.out.print("["+row[0] +","+ row[1]+"], ");
	}
	static public void neetcode_mergeintervals() {
		IntervalBundle lib = new IntervalBundle();
		int[][] result1 = lib.merge(new int[][] { {1,3}, {1,5}, {6,7} });
		System.out.print(" Answer 1: ");
		for(int[] row: result1 ) 
			System.out.print("["+row[0] +","+ row[1]+"], ");
		
		int[][] result2 = lib.merge(new int[][] { {1,2},{2,3} });
		System.out.print(" Answer 2: ");
		for(int[] row: result2 ) 
			System.out.print("["+row[0] +","+ row[1]+"], ");		

		int[][] result3 = lib.merge(new int[][] { {1,3},{8,10},{15,18},{2,6} });
		System.out.print(" Answer 3: ");
		for(int[] row: result3 ) 
			System.out.print("["+row[0] +","+ row[1]+"], ");		
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ NEETCODE MENU SOLUTIONS ]");
		System.out.println(" 1. longest palindrome substring");
		System.out.println(" 2. palindromic substrings ]");
		System.out.println(" 3. decode ways ");
		System.out.println(" 4. coin change");
		System.out.println(" 5. insert interval");
		System.out.println(" 6. merge intervals");
		int opc = scan.nextInt();
		switch(opc) {
			case 1: neetcode_longpalindrome();
					break;
			case 2: neetcode_palindromicsubstr();
					break;
			case 3:	neetcode_decodeways();
					break;
			case 4: neetcode_coinchange();
					break;
			case 5: neetcode_insertinterval();
					break;
			case 6: neetcode_mergeintervals();
					break;
			default: 
				    System.out.println("*** option not allowed ***");
		}
		

	}

}
