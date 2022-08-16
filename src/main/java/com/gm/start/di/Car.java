package com.gm.start.di;

import org.springframework.beans.factory.annotation.Autowired;

public class Car {

	// Car는 Engine이 없으면 x
	// Car는 Engine에 의존

	// 1. private Engine engine = new Engine();

	// 2.
	// Car car = new Car;
	// car.engine = new Engine();
	private Engine engine;
	private LeftWheel leftWheel;
	private RightWheel rightWheel;
	
	// 3.
//	public Car() {
//		this.engine = new Engine();
//	}
	public Car(Engine engine, LeftWheel leftWheel, RightWheel rightWheel) {
		this.engine = engine;
		this.leftWheel = leftWheel;
		this.rightWheel = rightWheel;
	}

	// Engine engine = new Engine();
	// Car car = new Car(engine);

	// 4.
//	{
//	this.engine = new Engine();
//	}

	// 5.
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
//	Car car = new Car();
//	Engine engine = new Engine();
//	car.setEngine(engine);

}
