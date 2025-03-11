package com.pattern.factory.factories;

import com.pattern.factory.cars.Car;

public abstract class Factory {
	public abstract Car create(String carname);
}
