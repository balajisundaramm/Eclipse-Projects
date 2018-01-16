package com.gokul.threadPractice;

import javax.swing.plaf.synth.SynthSpinnerUI;

public class ThreadyA {

	public static void main(String[] args) throws InterruptedException {
		ThreadyB tb=new ThreadyB();
		tb.start();
		// Thread.sleep(0,1); // just one NANO Second
		// On expecting update from child thread, sleep method or join() is not recommended, it has to sleep after result or 
		// child thread may be partially completed in main's sleep time.
		Thread.sleep(10000);
		synchronized (tb) {
			System.out.println("01.Main thread calling wait method");
			// Main thread saying I'm going to wait for thread tb(child thread) to complete and notify
			//tb.wait();
			tb.wait(5000);
			System.out.println("04.Main Thread received Notification call");
			System.out.println("05.Total is "+tb.total);
		}	
	}
}
class ThreadyB extends Thread{
	int total=0;
	public  void run() {
		synchronized (this) {
			System.out.println("02.child Thread starts Calculation");
			for(int i=1;i<101;i++) {
				total=total+i;
			}
			System.out.println("03.child sending notification");
			this.notify();
		}
	}
}
