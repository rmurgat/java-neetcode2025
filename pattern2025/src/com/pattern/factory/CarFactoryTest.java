package com.pattern.factory;

import com.pattern.factory.cars.Car;
import com.pattern.factory.factories.Factory;
import com.pattern.factory.factories.NissanFactory;
import com.pattern.factory.factories.ToyotaFactory;

public class CarFactoryTest {
	public static void main(String[] pars) {
		
		Car car = null;
		
		Factory factory = new ToyotaFactory();
		System.out.println("Creating Cars");
		
		car = factory.create("Corolla");
		System.out.println("Car created: " + car);
		car = factory.create("Camry");
		System.out.println("Car created: " + car);
		
		factory = new NissanFactory();
		car = factory.create("Tsuru");
		System.out.println("Car created: " + car);
		car = factory.create("Versa");
		System.out.println("Car created: " + car);
		
	}
}
