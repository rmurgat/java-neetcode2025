package com.oracle.java.refresh01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class OuterClass {
	int x = 10;

	class InnerClass {
		int y = 5;
	}
}

abstract class Animal {
	public abstract void sound();

	public abstract void eat();

	public void sleep() {
		System.out.println("-Zzzzz");
	}

	public void fly() {
		System.out.println("-All animals can fly in the mind");
	}
}

class Dog extends Animal {

	@Override
	public void sound() {
		System.out.println("-Barking the dog!");

	}

	@Override
	public void eat() {
		System.out.println("-Eating the dog!");
	}
}

enum Level {
	LOW,
	MEDIUM,
	HIGH
}

/**
 * Testing some thing from Java
 * [source:] https://www.w3schools.com/java/default.asp
 */
public class TestingJavaBasic {

	private int lowest(int[] ages) {
		int lowest = ages[0];
		for (int age : ages) {
			if (age < lowest) {
				lowest = age;
			}
		}
		return lowest;
	}

	private int sum(int last) {
		return (last == 0 ? 0 : last + sum(last - 1));
	}

	public void warmup_array() {
		int[] ages = { 20, 22, 18, 35, 48, 26, 87, 70 };
		float avg, sum = 0;
		int length = ages.length;
		for (int age : ages) {
			sum = sum + age;
		}
		avg = sum / length;
		int lowest = this.lowest(ages);
		System.out.println("...[int array]...");
		System.out.println("The average is:" + avg);
		System.out.println("The lowest aget: " + lowest);
	}

	public void warmup_multi_array() {
		int[][] nums = { { 1, 2, 3, 4 }, { 5, 6, 7 } };
		System.out.println("...[multi-dimensional int array]...");
		System.out.println(nums[1][2]);
		nums[1][2] = 9;
		for (int[] row : nums) {
			for (int i : row) {
				System.out.print(i + ", ");
			}
			System.out.println("");
		}
	}

	public void warmup_recursion() {
		System.out.println("...[recursion]...");
		System.out.print("sum: " + sum(10));
	}

	public void warmup_innerClasses() {
		OuterClass out = new OuterClass();
		OuterClass.InnerClass inner = out.new InnerClass();
		System.out.println("Inner Class: " + inner.y + ", " + out.x);
	}

	public void warmup_abstractclasses() {
		Animal dog = new Dog();
		dog.eat();
		dog.fly();
		dog.sound();
		dog.sleep();
	}

	public void warmup_arraylist() {
		System.out.println(" [ Warm-up ArrayList ] ");
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
		list.stream().forEach(System.out::println);
		ArrayList<String> cars = new ArrayList<>(Arrays.asList("Volvo", "BMW", "Ford", "Mazda"));
		Collections.sort(cars, Collections.reverseOrder());
		cars.stream().forEach(System.out::println);
	}

	public void warmup_hashmap() {
		System.out.println(" [ Warm-up HashMap ]");
		Map<String, String> hm = new Hashtable<>();
		hm.put("Englan", "London");
		hm.put("United States", "Washington DC");
		hm.put("Mexico", "Mexico City");
		hm.put("Argentina", "Buenos Aires");
		hm.put("Canada", "Toronto");
		List<Map.Entry<String, String>> list = hm.entrySet().stream().filter(entry -> entry.getKey().startsWith("A"))
				.collect(Collectors.toList());
		for (Map.Entry<String, String> entry : list) {
			System.out.println(entry.getKey() + "->" + entry.getValue());
		}
	}

	public void warmup_hashset() {
		System.out.println(" [ Warm-up hashSet ] ");
		String[] num = new String[] { "1", "2", "3", "42", "25", "666", "747", "899", "941", "100001" };
		Set<String> set = new HashSet<>();
		Arrays.stream(num).forEach(set::add);
		System.out.println("HashSet:");
		set.forEach(System.out::println);
		System.out.println("TreeSet:");
		Set<String> tset = new TreeSet<>(set);
		set.forEach(System.out::println);
	}

	public void warmup_iterator() {
		System.out.println(" [ Warm-up Iterator ] ");
		String[] num = new String[] { "1", "2", "3" };
		Iterator<String> it = Arrays.stream(num).iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public void warmup_wrapper() {
		System.out.println(" [ Warm-up Wrapper ] ");
		int[] nums = new int[] { 1, 2, 3, 4, 5, 6 };
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println("value=" + it.next());
		}
	}

	public void warmpu_exceptions() {

		// common use try ... catch and finally
		try {
			int[] nums = { 1, 2, 3, 4 };
			System.out.println(nums[10]);
		} catch (Exception e) {
			System.out.println("Something went wrong");
		} finally {
			System.out.println("running finally code");
		}

		// throw new exception
		try {
			int age = 12;
			if (age < 18) {
				throw new ArithmeticException("Access denied - You must be at least 18 years old.");
			} else {
				System.out.println("Access granted - You are old enough!");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void warmup_moreoperations() {
		String s = "One Two Three Four";
		int counter = s.split("\\s").length;
		System.out.println("Counter words: " + counter);
		
		int counter2 = (int) s.chars().filter(x->x==' ').count();
		System.out.println("Counter words: " + (counter2+1));
		
		// reversing string 1
		String reversed1 = "";
		for(int i=0; i<s.length(); i++) {
			reversed1 = s.charAt(i) + reversed1;
		}
		//reversing string 2
		byte[] arr = s.getBytes();
		byte[] res = new byte[arr.length];
		for(int i=0; i<arr.length; i++) {
			res[i] = arr[arr.length-i-1];
		}
		String reversed2 = new String(res);
		
		//reversing string 3
		StringBuilder strbuilder = new StringBuilder();
		strbuilder.append(s);
		String reversed3 = strbuilder.reverse().toString();
		
		//reversing string 4
		char[] achar = s.toCharArray();
		List<Character> list = s.chars().mapToObj(c->(char)c).collect(Collectors.toList());
		list = list.reversed();
		String reversed4 = list.stream().map(String::valueOf).collect(Collectors.joining());
		
		//reversing string 5
		Stack<Character> stack = new Stack<>();
		s.chars().mapToObj(c->(char)c).forEach(stack::add);
		String reversed5 = "";
		while (!stack.empty()) {
			reversed5 += stack.pop();
		}
		
		System.out.println("Reversing 1:" + reversed1);
		System.out.println("Reversing 2: " + reversed2);
		System.out.println("Reversing 3: " + reversed3);
		System.out.println("Reversing 4: " + reversed4);
		System.out.println("Reversing 4: " + reversed5);
		
		//smallest element
		int ages[] = {20, 22, 18, 35, 48, 26, 87, 70};
		int smallest = ages[0];
		for(int age: ages) {
			smallest = (age<smallest?age:smallest);
		}
		System.out.println("Smallest: " + smallest);
		
		//printing key-value from hashtable
		Map<String,String> ht = new Hashtable<>();
		ht.put("Mexico", "Mexico City");
		ht.put("EEUU", "Washington DC");
		ht.put("Brazil", "Sao Paulo");
		for(String country: ht.keySet()) {
			System.out.println("country: " + country + ", capital: "+ ht.get(country));
		}
		
		//printing enum...
		for(Level l: Level.values()) {
			System.out.println("level: " + l);
		}
		
		//printing random number
		int random = 0;
		for(int i=0; i<20; i++) { 
			random = (int)(Math.random() * 101);
			System.out.print(" random "+ (i+1) + ": " + random);
		}
		
	}

	public static void main(String[] args) {
		TestingJavaBasic app = new TestingJavaBasic();
		Scanner scan = new Scanner(System.in);
		int opc = 0;
		do {
			System.out.println("\n [ 	WARM-UP MAIN MENU ] ");
			System.out.println(" 1. int array             11. exceptions");
			System.out.println(" 2. multi-array           12. more operations");
			System.out.println(" 3. recursion");
			System.out.println(" 4. Inner Classes");
			System.out.println(" 5. abstract classes");
			System.out.println(" 6. arraylist");
			System.out.println(" 7. hashmap");
			System.out.println(" 8. hashSet");
			System.out.println(" 9. iterator");
			System.out.println(" 10. wrapper");
			System.out.println(" 99. Finish");
			opc = scan.nextInt();
			switch (opc) {
			case 1:
				app.warmup_array();
				break;
			case 2:
				app.warmup_multi_array();
				break;
			case 3:
				app.warmup_recursion();
				break;
			case 4:
				app.warmup_innerClasses();
				break;
			case 5:
				app.warmup_abstractclasses();
				break;
			case 6:
				app.warmup_arraylist();
				break;
			case 7:
				app.warmup_hashmap();
				break;
			case 8:
				app.warmup_hashset();
				break;
			case 9:
				app.warmup_iterator();
				break;
			case 10:
				app.warmup_wrapper();
				break;
			case 11:
				app.warmpu_exceptions();
				break;
			case 12:
				app.warmup_moreoperations();
				break;
			case 99:
				System.exit(0);
			default:
				System.out.println("...Don't exist this option...");
				break;
			}
		} while (opc != 99);
		scan.close();
	}

}
