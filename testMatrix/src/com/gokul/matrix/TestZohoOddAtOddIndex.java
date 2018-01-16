package com.gokul.matrix;

public class TestZohoOddAtOddIndex {

	public static void main(String[] args) {
		int[] inputArray={0,1,3,9,11,11,16,22,22,23,32,33,43,45,45,49,67,76,82,87,100};
		OddAtOddIndex(inputArray);
		
	}
	public static void OddAtOddIndex(int[] arr){
		
		System.out.println(" Odd number at Odd index is ");
		
		for(int i=1;i<arr.length;i+=2){
			if((arr[i]&1)==1)
			System.out.print(arr[i]+" ");
		}

	}

}
