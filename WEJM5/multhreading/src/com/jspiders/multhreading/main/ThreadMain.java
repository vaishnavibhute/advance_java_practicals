package com.jspiders.multhreading.main;

//import com.jspiders.multhreading.threads.MyThread1;
//import com.jspiders.multhreading.threads.MyThread2;
import com.jspiders.multhreading.threads.MyThread3;

public class ThreadMain {
	public static void main(String[] args) {
		
//		MyThread1 myThread1=new MyThread1();
//		
//		MyThread2 myThread2=new MyThread2();
//		Thread thread=new Thread(myThread2);
		
//		to check default value of name & priority
//		System.out.println(myThread1.getName());
//		System.out.println(myThread1.getPriority());
//		
//		System.out.println(thread.getName());
//		System.out.println(thread.getPriority());
		
//		to set name & priority
//		myThread1.setName("Thread-1");
//		myThread1.setPriority(9);
//		
//		thread.setName("Thread-2");
//		thread.setPriority(10);
//		
//		myThread1.start();
//	    thread.start();
		
//		stop()
		MyThread3 myThread3=new MyThread3();
		myThread3.start();
	}
}
