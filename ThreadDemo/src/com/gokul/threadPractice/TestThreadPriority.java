package com.gokul.threadPractice;

public class TestThreadPriority {
	
//	Thread MIN priority is 1
//	Thread NORM priority is 5
//	Thread MAX priority is 10 // This will have highest priority than others

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread thread1=new Thread();
		System.out.println("Thread MIN priority is "+thread1.MIN_PRIORITY);
		
		System.out.println("Thread NORM priority is "+thread1.NORM_PRIORITY);
		
		System.out.println("Thread MAX priority is "+thread1.MAX_PRIORITY);
		
		System.out.println("************");
		
		// Thread scheduler use priority while allocating process
		// Thread having highest priority will get the highest change
		// If two threads have same priority, order of execution is decided by THREAD SCHEDULER
		
		
		
		// Allowed priority values are 1 to 10
		
		// thread1.setPriority(newPriority);
		// thread1.getPriority();
		// DEFAULT PRIORITY of Main Thread is 5
		// For Remaining Threads defalt priority of thread is inherited from its Parent Thread
		
		
	System.out.println("Current thread - "+Thread.currentThread().getName()+" Thread's priority is "
	+Thread.currentThread().getPriority());
	
	// Setting priorities other than [1 to 10] leads to [ RE: ILLEAGAL ARGUMENT EXCEPTION ]
	//Thread.currentThread().setPriority(15);
	
	//Setting main thread's priority to 4
	Thread.currentThread().setPriority(4);
	System.out.println("Setting Current thread - "+Thread.currentThread().getName()
			+" thread's priority to "+Thread.currentThread().getPriority());
	
	// Main thread creating a child thread
	ThreadB mythread1=new ThreadB();
	//child thread's priority will obtained from its parent
	System.out.println("child thread's priority is "+mythread1.getPriority());
	
	// Parent thread is different and parent class is different
	//mythread1.setPriority(10);
	mythread1.start();   //Creating new child thread
	for(int i=0;i<10;i++) {
		System.out.println("Main Thread");
	}
	//IDEAL OUTPUT is printing "child thread" 10 times followed by "Main thread" 10 times
	//Some platforms won't provide proper support for Thread priorities
	// In that case we need to contact OS VENDOR
	}

	
}

