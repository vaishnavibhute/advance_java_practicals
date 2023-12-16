package com.jspiders.multhreading.threads;

import com.jspiders.multhreading.resource.Vehicle;

public class Bike extends Thread{

	Vehicle vehicle;

	public Bike(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;
	}
	
	@Override
	public void run() {
		synchronized (vehicle.dipika) {
			System.out.println(this.getName()+" locked"+vehicle.dipika);
			
			synchronized (vehicle.dipak) {
				System.out.println(this.getName()+" released"+vehicle.dipika);
			}
			System.out.println(this.getName()+" released"+vehicle.dipak);
		}
		System.out.println(this.getName()+" released"+vehicle.dipika);
	}
}
