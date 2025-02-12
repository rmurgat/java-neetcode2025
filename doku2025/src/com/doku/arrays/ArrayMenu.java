package com.doku.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.apache.commons.lang3.ArrayUtils;

public class ArrayMenu {
	
	public void sorting_arrays() {
		ArraysLib lib = new ArraysLib();
		System.out.println(" [ SORTING ARRAY ]");
		int[] original = { 5, 6, 9, 10, 1, 36 };
		int[] sorted1 = lib.sortarray_1(new int[] { 5, 6, 9, 10, 1, 36 } );
		System.out.print("Answer 1: [");
		Arrays.stream(sorted1).forEach(i->System.out.print(i + ","));
		System.out.println("]");
		System.out.println("Answer 2: (using libraries)");
		lib.sortarray_libraries(original);
	}
	
	public void summing_array() {
		ArraysLib lib = new ArraysLib();
		System.out.println(" [ SUMMING ARRAY ]");
		int[] array = { 1, 20, 13, 45, 15, 69, 72 };
		System.out.println(" Answer 1: " + lib.sum_1(array));
		lib.sumarray_libraries(array);
	}
	
	public void maxmin_array() {
		System.out.println(" [ MAX/MIN ARRAY ]");
		int[] array = { 1, 20, 13, 45, 15, 69, 72 };
		Integer[] array1 = { 1, 20, 13, 45, 15, 69, 72 };
		System.out.println(" Answer 1: (max) " + Arrays.stream(array).max().getAsInt());
		System.out.println(" Answer 2: (min) " + Arrays.stream(array).min().getAsInt());
		System.out.println(" Answer 3: (max) " + Arrays.stream(array1).mapToInt(i->i).max().getAsInt());
		System.out.println(" Answer 4: (min) " + Arrays.stream(array1).mapToInt(i->i).min().getAsInt());
		
	}
	
	public void filling_array() {
		int[] array = new int[10];
		Integer[] array1 = new Integer[10];
		String[] array2 = new String[10];
		System.out.println(" [ FILLING ARRAY ]");		
		Arrays.fill(array, -1);
		Arrays.fill(array1, -2);
		Arrays.fill(array2, "@");
		System.out.println(" Answer 1: (fill 0)" + Arrays.toString(array));
		System.out.println(" Answer 2: (fill 0)" + Arrays.toString(array1));
		System.out.println(" Answer 3: (fill @)" + Arrays.toString(array2));
	}
	
	public void reversing_array() {
		int[] array = { 1, 20, 13, 45, 15, 69, 72 };
		System.out.println(" [ REVERSING ARRAY ]");
		List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
		Collections.reverse(list);
		int[] array1 = list.stream().mapToInt(Integer::intValue).toArray();
		System.out.println(" Answer 1: (collection)" + Arrays.toString(array1));
	}
	
	public void get_subset_array() {
		int x = 1, y = 5;
		System.out.println(" [ SUBSET ARRAY ]");
		int[] a = IntStream.range(1, 100).toArray();
		int[] b = new int[10];
		b = Arrays.copyOfRange(a, 0, 9);
		System.out.println(" Answer 1: (arrays)" + Arrays.toString(b));
		int[] c = new int[] { x,y};
		System.out.println(" Answer 2:" + Arrays.toString(c));
	}
	
	public void get_average_array() {
		System.out.println(" [ AVERAGE ARRAY ]");
		int[] a100 = IntStream.range(0, 100).toArray();
		Double d = Arrays.stream(a100).average().getAsDouble();
		System.out.println(" Answer 1: " + d);
	}
	
	public void contain_value_array() {
		ArraysLib lib = new ArraysLib();
		System.out.println(" [ CONTAIN VALUE ARRAY ]");
		int[] a60 = IntStream.range(1, 60).toArray();
		int pos = Arrays.binarySearch(a60, 1546);
		System.out.println("Answer 1 (binary search): " + pos);
		
		int[] array1 = { 5, 1, 1, 9, 7, 2, 6, 10 };
		int locate = 7;
		System.out.println("Answer 2 (fun): " + lib.contain(array1, locate));
		System.out.println("Answer 3 (stream): " + Arrays.stream(array1).boxed().anyMatch(n->n==locate));
		
		// using ArrayUtils
		boolean contained = ArrayUtils.contains(array1, 9);
		System.out.println("Answer 4 (arrayutils): " + contained);
	}
	
	public void generate_values() {
		System.out.println(" [ GENERATE VALUES IN ARRAY ]");
		int[] a = IntStream.range(0, 100).toArray();
		int[] b = IntStream.iterate(0, i->i+2).limit(100).toArray();
		System.out.println("Answer 1 (range): " + Arrays.toString(a));
		System.out.println("Answer 2 (iterate): " + Arrays.toString(b));
	}
	
	public void locate_value() {
		System.out.println(" [ LOCATE VALUE IN ARRAY ]");
		int[] array1 = { 5, 1, 1, 9, 7, 2, 6, 10 };
		System.out.println("Answer 1 (arrayutils): " + ArrayUtils.indexOf(array1, 9));
		Integer[] array2 = { 5, 1, 1, 9, 7, 2, 6, 10 };
		System.out.println("Answer 2 (arrayutils): " + ArrayUtils.indexOf(array1, 9));
		List<Integer> list = Arrays.stream(array2).toList();
		System.out.println("Answer 3 (list): " + list.indexOf(9));
	}
	
	public void twist_way() {
		boolean twist=false;
		List<Integer> li1 = new ArrayList<>(), li2 = new ArrayList<>();; 
		System.out.println(" [ Twist Way ]");
		int[] array1 = { 5, 1, 1, 9, 7, 2, 6, 10 };
		for(int n: array1) {
			if(twist) li2.add(n);
			else li1.add(n);
			twist = !twist;
		}
		System.out.println("list 1:" + li1);
		System.out.println("list 2:" + li2);
	}
	
	public void greater_right() {
		int[] array1 = { 5, 1, 1, 9, 7, 2, 6, 10 };
		int[] ans1 = new int[array1.length];
		Arrays.fill(ans1, -1);
		for(int i=0; i<array1.length; i++)
			for(int j=i; j<array1.length; j++) 
				if(array1[j] > array1[i]) {
					ans1[i] = array1[j];
					break;
				}
		System.out.println("ini 1:" + Arrays.toString(array1));
		System.out.println("max 1:" + Arrays.toString(ans1));
		
		//using stack
		int[] ans2 = new int[array1.length];
		Arrays.fill(ans2, -1);
		Stack<Integer> stack = new Stack<>();
		for(int i=array1.length-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek()<=array1[i]) {
				stack.pop();
			}
			if(!stack.isEmpty()) {
				ans2[i] = stack.peek();
			}
			stack.push(array1[i]);
		}
		System.out.println("stack:" + stack + "\nans:" + Arrays.toString(ans2));
	}
	
	public void lower_right() {
		int[] array1 = { 5, 1, 1, 9, 7, 2, 6, 10 };
		int[] ans1 = new int[array1.length];
		Arrays.fill(ans1, -1);
		for(int i=0; i<array1.length; i++) {
			for(int j=i; j<array1.length; j++) {
				if (array1[j]<array1[i]) {
					ans1[i] = array1[j];
					break;
				}
			}
		}
		System.out.println("ini 1:" + Arrays.toString(array1));
		System.out.println("lower 1:" + Arrays.toString(ans1));
		
		//using stack
		int[] ans2 = new int[array1.length];
		Stack<Integer> stack = new Stack<>();
		Arrays.fill(ans2, -1);
		for(int i=array1.length-1; i>=0; i--) {
			while(!stack.isEmpty() && stack.peek()>=array1[i])
				stack.pop();
			if(!stack.isEmpty()) ans2[i] = stack.peek();
			stack.push(array1[i]);
		}
		System.out.println("lower 2:" + Arrays.toString(ans2));
	}
	


	public static void main(String[] args) {
		ArrayMenu app = new ArrayMenu();
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ MAMIN MENU ]           11. twist way ");
		System.out.println("1. sorting array          12. greater right");
		System.out.println("2. sum array              13. lower right");
		System.out.println("3. max/min array          14. ");
		System.out.println("4. filling array");
		System.out.println("5. reversing array");
		System.out.println("6. subset in array");
		System.out.println("7. average in array");
		System.out.println("8. contains value");
		System.out.println("9. generate values");
		System.out.println("10. locate value");
		System.out.println("");
		System.out.println("*select option: ");
		int opc = scan.nextInt();
		switch(opc) {
			case 1: app.sorting_arrays();
					break;
			case 2: app.summing_array();
					break;
			case 3: app.maxmin_array();
			        break;
			case 4: app.filling_array();
					break;
			case 5: app.reversing_array();
					break;
			case 6: app.get_subset_array();
					break;
			case 7: app.get_average_array();
					break;
			case 8: app.contain_value_array();
					break;
			case 9: app.generate_values();
					break;
			case 10: app.locate_value();
			        break;
			case 11: app.twist_way();
					break;
			case 12: app.greater_right();
					break;
			case 13: app.lower_right();
					break;
			default:
				System.out.println("*option not allowed");
		}

		scan.close();
	}

}
