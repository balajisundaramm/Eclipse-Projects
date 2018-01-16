package com.gokul.threadPractice;

public class TestThread {
//Main method run by MAIN Thread by default
	//EveryJava program contains one thread by default i.e MAIN Thread
	public static void main(String[] args) {
		
		//Thread Instantiation
		MyThread myThread=new MyThread();
		
		//Creating object of MyRunnable class
		MyRunnable myRunnable=new MyRunnable();
		
		//using my Runnable object(TARGET RUNNABLE) via constructor;
		//Thread parent->Code to the parent 
		Thread myThread2=new Thread(myRunnable);
		
		//Start() executing from Parent THREAD CLASS
		myThread.start(); //Default name for this thread  is Thread-0
		myThread2.start(); //Default name for this thread  is Thread-1
		//Setting Name to thread
		Thread.currentThread().setName("Pawan Kalyan@Main Thread");
		System.out.println("Main method executed by :"+Thread.currentThread().getName());
		
		//Changing the name of myThread2
		myThread2.setName("2Method-Thread");
		
		//Starting the started thread
		//myThread.start(); //will lead to Illegal Thread State Exception
		
		System.out.println("");
		System.out.println("Gonna create thread3 and thread4");
		Thread myThread3 =new Thread();
		Thread myThread4= new Thread(myRunnable);
		
		//case1: Start() of THREAD class will be invoked; new thread will be created
		//myThread3.start(); myThread3.getName();
		
		//case2: run() of THREAD class will be invoked; empty run method will be run
		//myThread3.run();
		
		//case3: Start() of THREAD class will be invoked; new thread will be created
		myThread4.start();
		//case4: run() of THREAD class will be invoked;run method of passed Runnable class will be executed
		myThread4.run();
		
		//Case 5: Compile time error. Could not find start() in myruunable class
		//myRunnable.start();
		
		//case6: run() will be invoked as a part of main thread
		myRunnable.run();
		
	}

}
