package com.jspiders.multhreading.threads;

import com.jspiders.multhreading.resource.Shop;

public class Customer extends Thread{
	Shop shop;

	public Customer(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void run() {
		shop.orderProducts(10);
	}
}
