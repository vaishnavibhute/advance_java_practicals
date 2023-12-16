package com.jspiders.multhreading.main;

import com.jspiders.multhreading.resource.Shop;
import com.jspiders.multhreading.threads.Customer;
import com.jspiders.multhreading.threads.Supplier;

public class ShopMain {
	public static void main(String[] args) {
		Shop shop= new Shop(5);
		Customer customer=new Customer(shop);
		Supplier supplier=new Supplier(shop);
	
		customer.start();
		supplier.start();
	}
}
