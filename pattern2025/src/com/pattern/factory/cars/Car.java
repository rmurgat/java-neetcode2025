package com.pattern.factory.cars;

public abstract class Car {
    private String agency;
    private String name;
    private double price;
    
	public Car() {	}
	
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Car [agency=" + agency + ", name=" + name + ", price=" + price + "]";
	}
	
}
