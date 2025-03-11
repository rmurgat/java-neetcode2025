package com.pattern.prototype;

public class Main {

	public static void main(String[] args) {
		AnimalCloneFactory factory = new AnimalCloneFactory();
		Animal animal=null;
		Animal animalcloned=null;
		
		System.out.println("Turn of the dog...");
		animal = new Dog();
		animalcloned = factory.getClone(animal);
		System.out.println(animal + " with ID " + System.identityHashCode(animal));
		System.out.println(animalcloned + " cloned with ID " + System.identityHashCode(animalcloned));

		System.out.println("Turn of the cat...");
		animal = new Cat();
		animalcloned = factory.getClone(animal);
		System.out.println(animal + " with ID " + System.identityHashCode(animal));
		System.out.println(animalcloned + " cloned with ID " + System.identityHashCode(animalcloned));		
	}

}
