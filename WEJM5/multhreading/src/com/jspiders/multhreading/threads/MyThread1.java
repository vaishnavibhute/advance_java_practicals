package com.jspiders.multhreading.threads;

public class MyThread1 extends Thread{
	@Override
	public void run() {
//		for(int i=1; i<=5 ;i++) {
//			System.out.println("MyThread1 is now running!!!");
//		}
		
//		to set the name & priority
		
		System.out.println("Name of Thread:"+this.getName());
		System.out.println("Priority of Thread:"+this.getPriority());
	}
}
