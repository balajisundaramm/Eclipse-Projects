package com.gokul.threadPractice;

// Threads where are executing in the BACKGROUND are called "DAEMON THREADS"
// Best Example: Garbage Collector, signal Dispatcher, Attach Listener

//ANALOGY--> People behind the screens for any movie, eg: producer,director,music director etc

//The main objective of demon thread is to PROVIDE SUPPORT for NON-DEMON Threads,
//(For  eg: if MAIN THREAD runs with LOW MEMORY,then JVM runs GARBAGE COLLECTOR to destroy USELESS objects,
//number of bytes of free memory will be improved, so that main thread can continue its execution
//During this scenario, JVM increases the GC's priority to HIGH, despite GC has low priority by default

// check DAEMON nature of thread using isDAEMON() method of THREAD CLASs
// we can daemon nature of a thread by using setDAEMON() method,
// but changing daemon nature is possible,only before starting a THREAD only,
// IF we change nature after starting a thread, we'll get ILLEGAL THREAD STATE EXCEPTION

// MAIN thread is NON-daemon by default. IMPOSSIBLE to change DAEMON NATURE of MAIN thread, because main gets started in first during the start of the program
// for all other threads are daemon nature of a thread is inherited from PARENT
// parent thread-->daemon, then child is demon


//Whenever last daemon threads terminates, all daemon threads will be terminated irrespective of their position
//No support is required from daemon thread, after last non-daemon completes
public class DaemonThreadDemo {

	public static void main(String[] args) {
		System.out.println("is main thread demon "+Thread.currentThread().isDaemon());
		// Below line leads to "Exception in thread "main" java.lang.IllegalThreadStateException"
		//Thread.currentThread().setDaemon(true);
		MyThread t=new MyThread();
		System.out.println("is Mythread obj T demon ? "+t.isDaemon());
		System.out.println("setting thread obj as daemon");
		t.setDaemon(true);
		System.out.println("is Mythread obj T demon ? "+t.isDaemon());
		ThreadF tf=new ThreadF();
		tf.setDaemon(true);
		tf.start();
		System.out.println("END OF MAIN THREAD");
		
		// Here MAIN thread is daemon, child thread is non-daemon
		// Whenever main thread  terminates, child thread will be terminated 
		// in this case, non-demon will be executed ZERO times or MAXIMUM ONE TIME
		
		
	}

}
class ThreadF extends Thread{
	public void run() {
		
		for(int i=0;i<10;i++) {
			System.out.println("Child Thread");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
