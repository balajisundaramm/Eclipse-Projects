package com.gokul.threadPractice;
//Defining a thread
public class MyThread extends Thread{
// This part is called -> JOB of the read
	//code inside run method is called JOB of THREAD
	/*public void start() {
		super.start();
		System.out.println("Start method");
	}*/
	public void run() {
		System.out.println("No-argument run method in MyThread class");
		System.out.println("Run method executed by :"+Thread.currentThread().getName());
	}
	public void run(String s) {
		System.out.println("Parametrised run method");
		}
}
class MyRunnable implements Runnable{

	@Override
	public void run() {
		System.out.println("No-argument run method in MyRunnable class");
		System.out.println("Run method executed by :"+Thread.currentThread().getName());
		
	}
	
}
