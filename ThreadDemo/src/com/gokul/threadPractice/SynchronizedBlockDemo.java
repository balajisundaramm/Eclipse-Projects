package com.gokul.threadPractice;

import com.gokul.threadPractice.SynchronizedBlockDemo.DisplayA;

// Synchronized Block--> If very few lines of code required synchronization,
// then it highly  recommended to declare those few lines of code in synchronized BLOCK in that same method.
// So that method will become non-Synchronized giving better performance and less WAITING time.


/*We can declare synchronized as follows
1. To get lock of current object 

synchronized (this) {
					......
					......
					}
// If a thread got a lock of current object,then above block is assured to be executed.
 * 
2. To get lock of Particular object-obj

synchronized (obj) {
					.....
					.....
					}
// If a thread got a lock of  object obj,then above block is assured to be executed
 * 
3.To get CLASS LEVEL LOCK
	synchronized (Display.class) {
								  .....
								  .....
								 }
If a thread got a CLASS LEVEL lock of DISPLAY class,then above block is assured to be executed.

WE CANNOT PASS PRIMITIVES AS ARGUMENT TO synchronized BLOCK
*/
public class SynchronizedBlockDemo {

	public static void main(String[] args) {
		SynchronizedBlockDemo x = null;
		
		DisplayA d=x.new DisplayA();
		MiThreadA t1=new MiThreadA(d, "Dhoni");
		MiThreadA t2=new MiThreadA(d, "yuvaraj");
		t1.start();
		t2.start();


}
class DisplayA{
	public DisplayA() {
		// TODO Auto-generated constructor stub
	}

		public  void wish(String name) {
			synchronized (this) {
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
	class MiThreadA extends Thread{
		DisplayA display;
		String name;
		public MiThreadA(DisplayA d,String n) {
			// TODO Auto-generated constructor stub
			this.display=display;
			this.name=n;
		}
		@Override
		public void run() {
			super.run();
			display.wish(name);	
		}
	}
