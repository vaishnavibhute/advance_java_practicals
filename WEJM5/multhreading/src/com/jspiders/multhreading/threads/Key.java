package com.jspiders.multhreading.threads;

import com.jspiders.multhreading.resource.Vehicle;

public class Key extends Thread{

	Vehicle vehicle;

	public Key(Vehicle vehicle) {
		super();
		this.vehicle = vehicle;
	}
	
	@Override
	public void run() {
		synchronized (vehicle.dipak) {
			System.out.println(this.getName()+" locked"+vehicle.dipak);
			
			synchronized (vehicle.dipika) {
				System.out.println(this.getName()+" released"+vehicle.dipak);
			}
			
			System.out.println(this.getName()+" released"+vehicle.dipak);
		}
	}
}
