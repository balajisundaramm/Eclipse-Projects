package com.gokul.matrix;

public class TestZohoCountZeroes {

	public static void main(String[] args) {
		int input=100023;
		countZeroes(input);
	}
public static void countZeroes(int input){
	int count=0;
	String s=tobinary(input);
	System.out.println("Eight bit binary form of given number is " +s);
	for(char c:s.toCharArray()){
	if(c=='0')
		count++;
	}
	System.out.println("Number of zeroes in the Eight bit binary form of given number is "+count);
}
public static String tobinary(int inputNum){
	String str="";
	while(inputNum>=1){
		str=inputNum%2+str;
		//System.out.println("str is "+str);
		inputNum=inputNum/2;
		//System.out.println("input num is "+inputNum);
	}
	if(str.length()<=8){
	for(int i=str.length();i<8;i++){
		str=0+str;
	}
	return str;
	}
	else if(str.length()>8){
	return str.substring(str.length()-8); }
	return str;
}
}
