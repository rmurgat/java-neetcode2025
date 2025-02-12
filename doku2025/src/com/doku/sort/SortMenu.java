package com.doku.sort;

import java.util.Arrays;
import java.util.Scanner;

public class SortMenu {

	static public void bubble_sort() {
		int[] a2sort = new int[] { 64, 34, 100, 25, 5, 2, 12, 34, 15, 7, 3, 1, 26, 33, 67, 69, 22, 11, 90 };
		System.out.println("[ Bubble Sort ]");
		System.out.println("[original:] " + Arrays.toString(a2sort));
		SortLib.bubbleSort(a2sort);
		System.out.println("[result:] " + Arrays.toString(a2sort));
	}

	static public void select_replace() {
		int[] a2sort = new int[] { 64, 34, 100, 25, 5, 2, 12, 34, 15, 7, 3, 1, 26, 33, 67, 69, 22, 11, 90 };
		System.out.println("[ Select and Replace Sort ]");
		System.out.println("[original:] " + Arrays.toString(a2sort));
		SortLib.selectionSort(a2sort);
		System.out.println("[result:] " + Arrays.toString(a2sort));
	}
	
	static public void counting_sort() {
		int[] a2sort1 = new int[] { 10, 4, 2, 2, 7, 8, 6, 3, 3, 1, 9, 5 };
		System.out.println("[ Counting Sort ]");
		System.out.println("[original:] " + Arrays.toString(a2sort1));
		SortLib.countSort(a2sort1);
		System.out.println("[result:] " + Arrays.toString(a2sort1));
	}
	
	static public void quick_sort() {
		int[] a2sort = new int[] { 64, 34, 100, 25, 5, 2, 12, 34, 15, 7, 3, 1, 26, 33, 67, 69, 22, 11, 90 };
		System.out.println("[ Quick Sort ]");
		System.out.println("[original:] " + Arrays.toString(a2sort));
		SortLib.quicksort(a2sort);
		System.out.println("[result:] " + Arrays.toString(a2sort));
		
	}

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		while (true) {
			System.out.println(" [ NEETCODE MENU SOLUTIONS ]");
			System.out.println(" 1. bubble sort");
			System.out.println(" 2. select and replace sort");
			System.out.println(" 3. counting sort");
			System.out.println(" 4. quick sort");
			System.out.println(" 99. to exit()");
			int opc = scan.nextInt();
			switch (opc) {
			case 1:
				bubble_sort();
				break;
			case 2:
				select_replace();
				break;
			case 3:
				counting_sort();
				break;
			case 4:
				quick_sort();
				break;
			case 99:
				scan.close();				
				System.exit(0);
				break;
			default:
				System.out.println("*** option not allowed ***");
			}
		}

	}

}
