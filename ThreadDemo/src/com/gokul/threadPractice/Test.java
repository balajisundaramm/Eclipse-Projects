package com.gokul.threadPractice;

class Vehicle {
    public void printSound() {
        System.out.print("vehicle");
    }
}

class Car extends Vehicle {
    public void printSound() {
        System.out.print("car");
    }
}

class Bike extends Vehicle {
    public void printSound() {
        System.out.print("bike");
    }
}

public class Test implements Runnable {
	public Test() {
		// TODO Auto-generated constructor stub
	}
    public static void main(String[] args) {

    /*    Vehicle v = new Car();
        Car c = (Car) v;
        v.printSound();
        c.printSound();*/
        Thread t = new Thread(new Test());
        t.run();
        t.run();
        t.start();
        
        
        System.out.print("Begin");
        try {
			t.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.print("End");
    }
    
    public void run() {
        System.out.print("Run");
    }
    }   
