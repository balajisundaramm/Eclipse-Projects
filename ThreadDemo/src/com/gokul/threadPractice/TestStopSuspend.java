package com.gokul.threadPractice;

public class TestStopSuspend {

	public static void main(String[] args) {
		//generateFibonaci(20);
		int[] array= {89,45,6,5,67,100};
		array=sortArray(array);
		for(int n:array) {
			System.out.println(n);
		}
	}
	public static int[] sortArray(int[] arr) {
		int temp=0;
		for(int i=0;i<arr.length;i++) {
			for(int j=0;j<arr.length-1;j++) {
				if(arr[j]>arr[j+1]) {
					
				/*temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;*/
				
				arr[j]=arr[j]^arr[j+1];
				arr[j+1]=arr[j]^arr[j+1];
				arr[j]=arr[j]^arr[j+1];
				}
			}
		}
		return arr;
	}
	
public static void generateFibonaci(int num) {
	int a=0,b=1,c=0;
	System.out.println(a);
	System.out.println(b);
	for(int i=0;i<num-2;i++) {
		c=a+b;
		System.out.println(c);
		a=b;
		b=c;
	}
	
}
}
