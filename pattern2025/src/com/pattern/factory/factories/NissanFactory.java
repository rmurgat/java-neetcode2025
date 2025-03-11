package com.pattern.factory.factories;

import com.pattern.factory.cars.*;

public class NissanFactory extends Factory {

	@Override
	public Car create(String carname) {
		Car car = null;
		switch(carname) {
			case "Tsuru":
				car = new Tsuru();
				break;
			case "Versa":
				car = new Versa();
		}
		return car;
	}

}
