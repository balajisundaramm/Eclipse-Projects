package com.gokul.threadPractice;
/*
IF  multiple threads are operating on same object simultaneously, then there arises DATA INCONSISTENCY PROBLEM
This is called RACE condition, We can overcome this problem,
we can overcome this by using Synchronized keyword or modifier

is a thread can have multiple locks at a time? YESSS!!! refer screenshots

statements present in synchronized methods or synchronized blocks are called SYNCHRONIZED STATEMENTS
*/
public class SynchronizedDemo {

	public static void main(String[] args) {
		Display d=new Display();
		Display d2=new Display();
		
/*		MiThread t1=new MiThread(d, "Dhoni");
		MiThread t2=new MiThread(d, "yuvaraj");
		MiThread t3=new MiThread(d, "kohli");
		MiThread t4=new MiThread(d, "Raina");*/
		//We CANNOT EXPECT the ORDER OF EXECUTION, It COMPLETLY DEPENDS on THREAD SCHEDULER
		
		MiThread t1=new MiThread(d, "Dhoni");
		MiThread t2=new MiThread(d, "yuvaraj");
		t1.start();
		t2.start();
		
		//Even though wish method is SYNCHRONIZED,WE'll get irregular output
		//IF multiple threads operating on SINGLE JAVA OBJECT, THEN SYNCHRONIZATION is REQUIRED.
		//t3.start();
		//t4.start();

		MiThread1 mit1=new MiThread1(d);
		MiThread2 mit22=new MiThread2(d);
		mit1.start();
		mit22.start();
	}

}
class Display{
//Without synchronized keyword, order of execution will be irregular, as all threads will be executing at a time
	// On using synchronized keyword, ONLY ONE thread is ALLOWED to execute and that thread will get
	//the lock of the object, Remaining threads will be in waiting State 
	//for the release of the lock of the object.
	//that means Regular execution of threads(one by one in any order) will be taken place
	
	// SYNCHRONIZED will give thread a OBJECT LEVEL LOCK
	// static SYNCHRONIZED will give thread a CLASS LEVEL LOCK, then irrespective any number of objects created for that class,
	//regular output will be carried OUT
	
	public  synchronized void wish(String name) {
		
		//public static synchronized void wish(String name)
		
		//While a thread executing STATIC synchronized method, remaining threads are not ALLOWED 
		//to EXECUTE any STATIC synchronized method of that class SIMULTANEOUSLY
// BUT remaining threads are allowed to EXECUTE below methods of that class SIMULTANEOUSLY
		// 01. Normal static methods
		//02. Synchronized instance methods
		//03. Normal instance methods
		// Refer pic-mt28 for further reference
			for(int i=0;i<10;i++) {
			System.out.print("Good Morning: ");
			
			try{
				Thread.sleep(1000);
			
			}catch (Exception e) {
			System.out.println("WISH interrupted");
		}
		System.out.println(name);
			}
	}
	public  synchronized void displayn() {
		for(int i=1;i<11;i++) {
			System.out.print(i);
		try{
			Thread.sleep(1000);
		
		}catch (Exception e) {
		System.out.println("Display interrupted");
		}
		}
	}
	public  synchronized void displayc() {
		for(int i=65;i<76;i++) {
			System.out.print((char)i);
		try{
			Thread.sleep(1000);
		
		}catch (Exception e) {
		System.out.println("Display interrupted");
	}
	}
	}
}
class MiThread extends Thread{
	Display display;
	String name;
	public MiThread(Display d,String n) {
		// TODO Auto-generated constructor stub
		this.display=d;
		this.name=n;
	}
	@Override
	public void run() {
		super.run();
		display.wish(name);	
	}
}
class MiThread1 extends Thread{
	Display display;

	public MiThread1(Display d) {
		// TODO Auto-generated constructor stub
		this.display=d;
	}
	@Override
	public void run() {
		super.run();
		display.displayn();	
	}
}
class MiThread2 extends Thread{
	Display display;

	public MiThread2(Display d) {
		// TODO Auto-generated constructor stub
		this.display=d;
	}
	@Override
	public void run() {
		super.run();
		display.displayc();	
	}
}
