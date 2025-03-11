package com.doku.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreaMenu {
	
	static class Student implements Comparable<Student> {
		public String name;
		public int age;
		public int grade;
		public String address;
		public Student(String name, int age, int grade, String address) {
			this.name=name;
			this.age=age;
			this.grade=grade;
			this.address=address;
		}
		public String toString() {
			return "Student[name:"+name+",age:"+age+",grade:"+grade+",address:"+address+"]";
		}
		public boolean isMore30() { 
			return this.age>30?true:false;
		}
		@Override
		public int compareTo(Student arg0) {
			return name.compareTo(arg0.name);
		}
	}
	
	static class Person {
		public String name;
		public Gender gender;
		public int age;
		public Person(String name, int age) {
			this.name=name;
			this.age=age;
			this.gender=Gender.UNDEFINED;
		}		
		public Person(String name, int age, Gender gender) {
			this.name=name;
			this.age=age;
			this.gender=gender;
		}
		public String toString() {
			return "Person[name:"+name+",age:"+age+",gender:"+gender+"]";
		}
	}
	
	static enum Gender {
		MALE, FEMALE, UNDEFINED
	}
	
	static class sortStudentByAge implements Comparator<Student> {
		@Override
		public int compare(Student arg0, Student arg1) {
			return arg1.age - arg0.age;
		}
	}
	
	public static List<Student> getStudents() {
		List<Student> list = new ArrayList<>();
		list.add(new Student("ruben",32,10,"mexico city"));
		list.add(new Student("fredy",30,5,"chilpancingo"));
		list.add(new Student("antonio",27,2,"acapulco"));
		list.add(new Student("javier",22,3,"cuernavaca"));
		list.add(new Student("rolando",25,4,"guadalajara"));
		list.add(new Student("ernesto",26,5,"puebla"));
		list.add(new Student("victor",33,6,"queretaro"));
		return list;
	}
	
	public static void quickRefreshUdemyCourse() {
		int[] versions = new int[] {2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
		List<Integer> javaVersionList = new ArrayList<>();
		javaVersionList.addAll(Arrays.stream(versions).boxed().collect(Collectors.toList()));
		
		Stream<Integer> stream =  javaVersionList.stream();
		Stream<Integer> stream_odd =  javaVersionList.stream();
		Stream<Integer> evenJavaVersion = stream.filter(v->v%2==0);
		Stream<Integer> oddJavaVersion = stream_odd.filter(v->v%2!=0);
		List<Integer> evenJavaVersionList = evenJavaVersion.collect(Collectors.toList());
		List<Integer> oddJavaVersionList = oddJavaVersion.collect(Collectors.toList());
		System.out.println(" [ EXAMPLE 1: PRINTING EVEN JAVA VERSIONS: ]" + evenJavaVersionList);
		System.out.println(" [ .......... PRINTING ODD JAVA VERSIONS: ]" + oddJavaVersionList);

		//example with object
		List<Student> list = getStudents();
		Stream<Student> stream1 = list.stream();
		Stream<Student> stream2 = stream1.filter(obj->obj.grade>3).filter(Student::isMore30); 
		List<Student> listgreater3 = stream2.collect(Collectors.toList());
		System.out.println(" [ EXAMPLE 2: list greater than grade 3 ] ");
		listgreater3.forEach(System.out::println);
		
		//example using function-interfaz
		System.out.println(" [ EXAMPLE 3: list greater than grade 3 ] ");
		Stream<Student> stream3 = list.stream().filter(s->!s.isMore30()&&s.grade>2);
		List<Student> list1 = stream3.toList();
		list1.forEach(System.out::println);
	}
	
	public static void sortedStudents() {
		List<Student> list = getStudents();
		Stream<Student> stream = list.stream();
		System.out.println(" [ TESTING SORTED() ]");
		List<Student> sorted = stream.sorted().toList();
		System.out.println("...sorted by name");
		sorted.forEach(System.out::println);
		Stream<Student> stream1 = list.stream();
		System.out.println("...sorted by age");
		List<Student> sorted1 = stream1.sorted(new sortStudentByAge()).toList();
		sorted1.forEach(System.out::println);
		
	}
	
	public static void limitStudents() {
		List<Student> list = getStudents();
		Stream<Student> stream1 = list.stream();
		Stream<Student> stream2 = stream1.limit(2);
		List<Student> limited2 = stream2.toList();
		System.out.println(" [ TESTING LIMIT() ]");
		limited2.forEach(System.out::println);
	}
	
	public static void peekStudents() {
		List<Student> list = getStudents();
		Stream<Student> stream1 = list.stream();
		stream1.peek(System.out::println).forEach(x->{});;
	}
	
	public static void mapping2newObject() {
		List<Student> list = getStudents();
		Stream<Student> stream1 = list.stream();
		Stream<Person> stream2 = stream1.map(obj -> new Person(obj.name,obj.age));
		List<Person> list3 = stream2.toList();
		System.out.println(" [ TESTING MAP() ]");
		list3.forEach(System.out::println);
	}
	
	public static void flatmap2Students() {
		List<Student> list = getStudents();
		Stream<Student> stream = list.stream();
		Stream<Person> stream1 = stream.flatMap(obj->Stream.of(
				                                new Person("A-"+obj.name, obj.age), 
				                                new Person("B-"+obj.name, obj.age), 
				                                new Person("C-"+obj.name, obj.age)) );
		List<Person> list1 = stream1.toList();
		System.out.println(" [ TESTING FLATMAP() ]");
		list1.forEach(System.out::println);
	}
	
	public static void playingWithGenders() {
		List<Person> people = List.of(
						new Person("fredy", 1, Gender.MALE),
						new Person("carlos", 1, Gender.MALE),
						new Person("eva", 1, Gender.FEMALE),
						new Person("edith", 1, Gender.FEMALE),
						new Person("ana laura", 2, Gender.FEMALE),
						new Person("Martin",2, Gender.MALE)
					);
		Predicate<Person> personPredicate = person->person.gender.equals(Gender.FEMALE);
		List<Person> females = people.stream().filter(personPredicate).collect(Collectors.toList());
		System.out.println(" [ PRINTING FEMALES ]");
		females.forEach(System.out::println);
				
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ STREAMS MENU ] ");
		System.out.println(" 1. filter() intermediate function             11. playing with genders");
		System.out.println(" 2. sorted() intermediate function");
		System.out.println(" 3. limit() intermediate function");
		System.out.println(" 4. peek() intermediate function");
		System.out.println(" 5. map() intermediate function");
		System.out.println(" 6. flatMap() intermediate funciton");
		int opc = scan.nextInt();
		switch(opc) {
			case 1: quickRefreshUdemyCourse();
					break;
			case 2: sortedStudents();
					break;
			case 3: limitStudents();
					break;
			case 4: peekStudents();
					break;					
			case 5: mapping2newObject();
					break;
			case 6: flatmap2Students();
					break;
			case 11: playingWithGenders();
					break;
			default:
					System.out.println("** option not allowed **");
		}
		scan.close();
	}

}
