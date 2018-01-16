package com.gokul.matrix;

public class TestCodeEval {

	public static void main(String[] args) {
		int[] a= {2,4,3,2,3,5,6,7,3};
		System.out.println(haveThree(a));
	}
static boolean haveThree(int[] a) {
	int count=0;
	for(int i=0;i<a.length-1;i++) {
		if(a[i]==3 && a[i+1]!=3)
		count++;
		}
	if(a[a.length-1]==3 && a[a.length-2]!=3)
		count++;
	System.out.println(count);
	return count==3;
}
}
