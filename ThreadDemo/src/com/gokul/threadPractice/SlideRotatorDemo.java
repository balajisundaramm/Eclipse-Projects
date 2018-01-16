package com.gokul.threadPractice;

public class SlideRotatorDemo extends Thread {

	public static void main(String[] args) throws InterruptedException {
		for(int i=1;i<=10;i++) {
			System.out.println("Showing Slide "+i);
			//Thread.sleep(1000);
		}
		System.out.println("THANK YOU");
		ThreadE.gotThread=Thread.currentThread();
		ThreadE myThreadE=new ThreadE();
		myThreadE.start();
		// Asking main thread to interrupt child by calling ->myThreadE.interrupt()
		myThreadE.interrupt();
		//interrupt method will always interrupt the targeted thread if it goes to sleeping state
		//interrupt must not let its target to SLEEP
	}

}
