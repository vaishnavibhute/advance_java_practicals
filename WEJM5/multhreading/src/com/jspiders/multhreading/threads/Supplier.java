package com.jspiders.multhreading.threads;

import com.jspiders.multhreading.resource.Shop;

public class Supplier extends Thread{
	Shop shop;

	public Supplier(Shop shop) {
		this.shop = shop;
	}
	
	@Override
	public void run() {
		shop.restockProducts(20);
	}
}
