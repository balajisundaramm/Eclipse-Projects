package com.gokul.matrix;

public class TestZohoMergeAndSort {

	public static void main(String[] args) {
		int a[] ={33,3,45,1,67,23,11,76,22,49,9};
		int[] b={11,22,45,87,43,32,82,100,0,16};
		mergeAndSort(a,b);
	}
public static void mergeAndSort(int[] a,int[] b){
	int[] c=new int[a.length + b.length];
	
	for(int i=0;i<a.length;i++){
		c[i]=a[i];
	}
	int alength=a.length;
	for(int n:b){
		c[alength++]=n;
	}
	for(int i=0;i<c.length;i++){
		for(int j=0;j<c.length-1;j++){
			if(c[j]>c[j+1]){
				c[j]=c[j]^c[j+1];
				c[j+1]=c[j]^c[j+1];
				c[j]=c[j]^c[j+1];
			}
		}
	}
	System.out.println("Result Merged and sorted Array contens are ");
	for(int n:c){
	System.out.print(" "+n);
	}
}
}
