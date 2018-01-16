package com.gokul.threadPractice;

public class DeadLockDemo {
// If two threads are waiting for each other forever,such type of waiting is called DEADLOCKS
// <---Infinite WAITING--->
// SYNCHRONIZED keyword is the only MAIN REASON for DEADLOCK Situation, hence we have 
// to take special care.
// There are no resolution techniques for DEADLOCKS, but there are PREVENTION TECHNIQUES
// If you remove atleast one "synchronized" keyword, program may not fall into DEALOCK
// Hence,SYNCHRONIZED keyword is the only MAIN REASON for DEADLOCK Situation, hence we have 
// to take special care.
	
// DEADLOCKS- Long waiting of thread that never ENDS
// STARVATION-Long waiting of thread that take very LONG TIME to END.(waiting ends at certain pt of time)
	
// For example, Low priority threads have to wait, until the completion of HIGH priority threads
// It may be long waiting,but ends at CERTAIN point-THIS IS STARVATION
	public static void main(String[] args) {
		

	}

}
