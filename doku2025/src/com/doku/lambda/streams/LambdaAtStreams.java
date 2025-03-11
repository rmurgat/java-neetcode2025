package com.doku.lambda.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * source course: Functional Programming in Java - Full Course - https://www.youtube.com/watch?v=rPSL1alFIjI
 */
public class LambdaAtStreams {
	
	static class Person {
		public String name;
		public Gender gender;

		public Person(String name, Gender gender) {
			this.name = name;
			this.gender = gender;
		}

		public String toString() {
			return "Person[name:" + name + ",gender:" + gender + "]";
		}
	}

	static enum Gender {
		MALE, FEMALE, PREFER_NOT2SAY
	}
	
	static List<Person> initListPersons() {
		List<Person> list = new ArrayList<>();
		list.add(new Person("fredy", Gender.MALE));
		list.add(new Person("eva", Gender.FEMALE));
		list.add(new Person("victor", Gender.MALE));
		list.add(new Person("rosy", Gender.FEMALE));
		list.add(new Person("alberto", Gender.MALE));
		list.add(new Person("maria", Gender.FEMALE));
		list.add(new Person("roberto", Gender.PREFER_NOT2SAY));
		list.add(new Person("javier", Gender.MALE));
		return list;
	}
	
	public static void usingFilter() {
		List<Person> list = initListPersons();
		List<Person> females = list.stream().filter(person->person.gender.equals(Gender.FEMALE)).toList();
		System.out.println(" [ using Filter() ]");
		females.forEach(person->System.out.println(person));
	}
	
	public static void usingAllMatch() {
		List<Person> list = initListPersons();
		boolean allareFemales = list.stream().allMatch(person->person.gender==Gender.FEMALE);
		boolean anyFemales = list.stream().anyMatch(person->person.gender.equals(Gender.FEMALE));
		boolean noneNot2Say = list.stream().noneMatch(person->person.gender.equals(Gender.PREFER_NOT2SAY));
		System.out.println(" [ using AllMatch() ]");
		System.out.println(" Answer 1 (have females): " + allareFemales);
		System.out.println(" Answer 2 (any females): " + anyFemales);
		System.out.println(" Answer 3 (none not2say): " + noneNot2Say);
	}
	
	public static void usingSuppliers() {
		System.out.println(" [ using Suppliers() ]");
		
	}
	

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ Practicing Lambda @ Streams ]");
		System.out.println(" 1. using allMatch()");
		System.out.println(" 2. using allMatch()");
		System.out.println(" 3. using Supplier()");
		System.out.println("*4. implementing combinator pattern (to validations)");
		System.out.println("*6. implementing callback using Consumer (as javascript)");
		System.out.println("*7. launch exception from function");
		int op = scan.nextInt();
		switch(op) {
			case 1: usingFilter();
				break;
			case 2: usingAllMatch();
				break;
			case 3: usingSuppliers();
				break;
			default:
				System.out.println("**Option not allowed**");
		}
		scan.close();

	}

}
