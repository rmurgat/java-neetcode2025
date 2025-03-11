package com.doku.lambda;

import java.util.List;
import java.util.Scanner;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


@FunctionalInterface
interface Calculator {
	int ope(int a, int b);
}

public class LambdaMenu {
	
	public static Function<Integer,Integer> increment = number -> number + 1;
	public static Function<Integer,Integer> multiply10 = number -> number * 10;
	public static Function<Integer,Integer> add1AndMultiply10 = increment.andThen(multiply10);
	public static BiFunction<Integer,Integer,Integer> bifunction = (p1,p2)->(p1+1)*p2;
	public static Consumer<Customer> greetings = customer -> System.out.println("Hello " + customer.name + ", thanks for number: "+customer.phone);
	public static BiConsumer<Customer, String> bigreetings = (customer,wife) -> System.out.println("Hello " + customer.name + ", wife: " + wife + ", number: "+customer.phone);
	
	public static Predicate<String> isPhoneNumberValid = phoneNumber->phoneNumber.startsWith("07") && phoneNumber.length()==11;
	public static Predicate<String> containsNumber3 = phoneNumber->phoneNumber.contains("3");
	
	public static BiPredicate<String,Integer> isValidCandidate = (name,salary)->name.contains("x") && salary>100; 
	
	public static Supplier<List<String>> getDBConnectionUrl = () -> List.of("jdbc://localhost:5432/users","jdbc://localhost:5432/customers");
	
	public static void overloadingLambda() {
		
		Calculator suma = (x,y)->x+y;
		System.out.println(" [ OVERLOADING LAMBDA ]");
		System.out.println("Result 1, sum using lambda: " + suma.ope(5,4));
		Calculator multi = (x,y)->x*y;
		System.out.println("Result 2, mult using lambda: " + multi.ope(5,4));
		Calculator divi = (x,y)->x/y;
		System.out.println("Result 3, division using lambda: " + divi.ope(10,5));
	}
	
	public static void usingFunctionandBiFunction() {
		System.out.println(" [ USING FUNCTION<> + BIFUNCTION<> ]");
		
		int result = increment.apply(1);
		System.out.println("Incremental Function: " + result );
		System.out.println("Increment then Multiply (using Function): " + add1AndMultiply10.apply(1));
		System.out.println("Increment then Multiply (using BiFunction): " + bifunction.apply(1,10));
	}
	
	static class Customer {
		public String name;
		public String phone;
		Customer(String p1, String p2) {
			name= p1;
			phone= p2;
		}
	}
	
	public static void usingConsumerAndBiConsumer() {
		System.out.println(" [ USING Consumer<> ]");
		greetings.accept(new Customer("ruben","999"));
		
		System.out.println(" [ USING BiConsumer<> ]");
		bigreetings.accept(new Customer("ruben","999"), "eva");
	}

	public static void usingPredicatesAndBiPredicate() {
		System.out.println(" [ USING Predicate<> ]");
		System.out.println(" ... Is phone number valid and/or contains number 3");
		System.out.println(" Answer 1: " + isPhoneNumberValid.and(containsNumber3).test("07123456789"));	
		System.out.println(" Answer 2: " + isPhoneNumberValid.and(containsNumber3).test("04123456789"));	
		System.out.println(" Answer 2: " + isPhoneNumberValid.or(containsNumber3).test("03"));
		
		System.out.println(" [ USING BiPredicate<> ]");
		System.out.println(" is Valid candidate: " + isValidCandidate.test("xavier", 105));
	}
	
	public static void usingSuppliers() {
		
		System.out.println(" [ USING Suppliers<> ]");
		System.out.println(" Answer 1: " + getDBConnectionUrl.get() );
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println(" [ LAMBDA MENU ] ");
		System.out.println(" 1. overloading lambda function");
		System.out.println(" 2. using Function and BiFunction");
		System.out.println(" 3. using Consumer and BiConsumer");
		System.out.println(" 4. using Predicate and BiPredicate");
		System.out.println(" 5. suppliers");
		int opc = scan.nextInt();
		switch (opc) {
		case 1: overloadingLambda();
			break;
		case 2: usingFunctionandBiFunction();
			break;
		case 3: usingConsumerAndBiConsumer();
			break;
		case 4: usingPredicatesAndBiPredicate();
			break;
		case 5: usingSuppliers();
			break;
			
		default:
			System.out.println("** option not allowed **");
		}
		scan.close();
	}

}
