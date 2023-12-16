package com.jspiders.adapterpattern.main;

import com.jspiders.adapterpattern.adapter.EmpEventAdapter;

public class AdapterMain {
		
	public static void main(String[] args) {
		
		EmpEventAdapter adapter = new EmpEventAdapter();
		adapter.id=1;
		adapter.name="ABC";
		adapter.email="ABC@123gmail.com";
		adapter.contact=1234567890;
		adapter.designation="Backend Developer";
		
		adapter.womenDay();
	}
}
