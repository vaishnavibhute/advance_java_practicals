package com.jspiders.adapterpattern.adapter;

import com.jspiders.adapterpattern.entity.Employee;
import com.jspiders.adapterpattern.entity.Event;

public class EmpEventAdapter extends Employee implements Event{

	@Override
	public void womenDay() {
		System.out.println("Chief guest of events:"+this.name);
		System.out.println("Her designation is:"+this.designation);
	}

}
