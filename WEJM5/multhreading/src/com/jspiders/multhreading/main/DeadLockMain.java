package com.jspiders.multhreading.main;

import com.jspiders.multhreading.resource.Resource;
import com.jspiders.multhreading.threads.Thread1;
import com.jspiders.multhreading.threads.Thread2;

public class DeadLockMain {
	public static void main(String[] args) {
		
		Resource resource=new Resource();
		
		Thread1 thread1=new Thread1(resource);
		thread1.setName("T1");
		
		Thread2 thread2=new Thread2(resource);
		thread2.setName("T2");
		
		thread1.start();
		thread2.start();
	}
}
