package com.gokul.threadPractice;

public class TestJoinDemo {

	//Developer must compulsory use try-catch or Throws [InterruptedException] on using JOIN method in his code
	public static void main(String[] args) throws InterruptedException {
		ThreadC myThreadC=new ThreadC();
		//myThreadC.start();
		
		myThreadC.join();// Main thread will wait until child thread(myThreadC) gets completed
		
		
		//"seconds" convention is to be in Milliseconds only
		//myThreadC.join(10000);// Main thread will wait for child thread for 10 SECONDS only
		for(int i=0;i<10;i++) {
			System.out.println("Rama Thread "+(i+1)+"times");
			//Thread.sleep(1000);
		}
		System.out.println("**************");
		ThreadD.gotThread=Thread.currentThread();
		ThreadD myThreadD=new ThreadD();
		myThreadD.start();
		
		// case 3: If main thread calls join on child thread and child thread calls join on main thread
		// then both threads will wait for each other forever, program will get struck
		// This is called DEADLOCKS
		
		///<---DEAD LOCK--> myThreadD.join();
		for(int i=0;i<10;i++) {
			System.out.println("Main Thread "+(i+1)+"times");
			
		}
		
	//case4: If a thread calls join() on the same thread itself, then the program will be struck
	// In this case thread has to wait infinite amount of times 
	// This is something like DEADLOCKS
		Thread.currentThread().join();
	}

}

