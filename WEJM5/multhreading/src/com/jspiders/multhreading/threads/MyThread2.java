package com.jspiders.multhreading.threads;


public class MyThread2 implements Runnable{
	@Override
	public void run(){
//		for(int i=1; i<=5; i++){
//			System.out.println("MyThread2 is now running!!!");
//		}
		
//		to set name & priority
		System.out.println("Name of Thread:"+Thread.currentThread().getName());
		System.out.println("Priority of Thread:"+Thread.currentThread().getPriority());
	}
}
