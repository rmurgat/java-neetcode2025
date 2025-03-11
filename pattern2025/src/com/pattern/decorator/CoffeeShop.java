package com.pattern.decorator;

public class CoffeeShop {

	public static void main(String[] args) {
		HouseBlend houseBlend = new HouseBlend();
		System.out.println(houseBlend.getDescription() + ": " + houseBlend.cost());
		
		Milk milkAddOn = new Milk(houseBlend);
		System.out.println(milkAddOn.getDescription() + ": " + milkAddOn.cost());

		Sugar sugarMilkAddOn = new Sugar(milkAddOn);
		System.out.println(sugarMilkAddOn.getDescription() + ": " + sugarMilkAddOn.cost());
	}

}
