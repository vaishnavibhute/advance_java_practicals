package com.jspiders.multhreading.main;

import com.jspiders.multhreading.resource.Vehicle;
import com.jspiders.multhreading.threads.Bike;
import com.jspiders.multhreading.threads.Key;

public class BikeMain {
	public static void main(String[] args) {
		
		Vehicle vehicle=new Vehicle();
		
		Bike bike1 = new Bike(vehicle);
		bike1.getName();
		
		Key key1=new Key(vehicle);
		key1.getName();
		
		bike1.start();
		key1.start();
	}
}
