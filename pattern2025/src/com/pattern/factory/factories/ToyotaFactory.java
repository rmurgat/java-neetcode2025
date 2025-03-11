package com.pattern.factory.factories;

import com.pattern.factory.cars.Camry;
import com.pattern.factory.cars.Car;
import com.pattern.factory.cars.Corolla;

public class ToyotaFactory extends Factory {

	@Override
	public Car create(String carname) {
		Car car = null;
		switch(carname) {
		case "Camry":
			car = new Camry();
			break;
		case "Corolla":
			car = new Corolla();
			break;
		}
		return car;
	}

}
