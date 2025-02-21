package com.doku.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ArraysLib {
	
	// SORTING ARRAY - SELECT & REPLACE method
	public int[] sortarray_1(int[] nums) {
		for(int select=0; select<nums.length; select++) {
			int lower = select;
			
			for (int i=select+1; i<nums.length; i++) {
				if( nums[i] < nums[lower] )
					lower = i;
			}
			int tmp = nums[select];
			nums[select] = nums[lower];
			nums[lower] = tmp;
		}
		return nums;
	}
	
	public int[] reverse(int[] nums) {
		int[] ans = new int[nums.length];
		int i = nums.length-1;
		for(int n:nums) 
			ans[i--]=n;
		return ans;
	}
	
	// Sorting using libraries...
	public void sortarray_libraries(int[] nums) {
		int[] array1 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(array1);
		System.out.print("Sorted 1: ");
		Arrays.stream(array1).forEach(i->System.out.print(i + ","));
		int[] array2 = Arrays.copyOf(nums, nums.length);
		int[] sorted2 = Arrays.stream(array2).sorted().toArray();
		System.out.println();
		System.out.print("Sorted 2: ");
		Arrays.stream(sorted2).forEach(i->System.out.print(i+","));
		Integer[] array21 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		System.out.print("\nSorted 3: ");
		Comparator<Integer> comparator = Collections.reverseOrder();
		Arrays.sort(array21, comparator);	
		Arrays.stream(array21).forEach(i->System.out.print(i+","));
		System.out.println("\nInverting...");
		int[] array3 = Arrays.copyOf(nums, nums.length);
		List<Integer> list3 = Arrays.stream(array3).boxed().collect(Collectors.toList());
		// List<Integer> list4 = new ArrayList<>();
		Collections.sort(list3,Collections.reverseOrder());
		System.out.print("list:");
		list3.forEach(n->System.out.print(n+","));
		System.out.println("\nfunc: " + Arrays.toString(reverse(sorted2)));
		// list3.reversed().forEach(n->list4.add(n));
		// System.out.println("\nplay: " + list4);
	}
	
	public int sum_1(int[] nums) {
		int sum=0;
		for(int i: nums) {
			sum += i;
		}
		return sum;
	}
	
	public void sumarray_libraries(int[] nums) {
		int sum1 = Arrays.stream(nums).sum();
		System.out.print(" sum using streams I: " + sum1 + "\n");
		Integer[] array1 = Arrays.stream(nums).boxed().toArray(Integer[]::new);
		Integer sum2 = Arrays.stream(array1).mapToInt(i->i).sum();
		System.out.println("Sum using stream II: " + sum2);
	}
	public int max_1(int[] nums) {
		return Arrays.stream(nums).max().getAsInt();
	}
	public boolean contain(int[] nums, int val) {
		for(int n: nums) {
			if(n==val) return true;
		}
		return false;
	}
}
