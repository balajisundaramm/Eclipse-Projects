package com.gokul.threadPractice;

public class ThreadB extends Thread{
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
			Thread.yield();
	// It gives more number of chances to main() method which is waiting with same priority
	// If we comment--> Thread.yield(); then order of execution depends on THREAD SCHEDULER
		
		//NOTE: Some platform won't provide proper support for yield() Method
		}
	}
}
class ThreadC extends Thread{
	
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("Seetha Thread "+(i+1)+"times");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}

// case2: Child Thread waiting for MAIN thread to gets completed
class ThreadD extends Thread{
	
	static Thread gotThread;
	public void run() {
		try {
			//got thread is assigned as main thread from main(); 
			//see main method for this-ThreadD.gotThread=Thread.currentThread();
			gotThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		for(int i=0;i<10;i++) {
			System.out.println("child Thread "+(i+1)+"times");
			
		}
	}
	
}
class ThreadE extends Thread{
	
	static Thread gotThread;
	public void run() {
		for(int i=0;i<200;i++) {
			System.out.println("Printing i "+i);
		}
		try {
				System.out.println("I am a lazy Thread, entering into Sleeping state");
				Thread.sleep(1000);	
		} catch (InterruptedException e) {
			System.out.println("I'm Lazy Thread,my sleeping got interrutped by "+gotThread);
		}
		
	}
	
}
