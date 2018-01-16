package com.gokul.matrix;

import java.util.Scanner;

public class Printspiral {

	public static void main(String[] args) {
		
		int a[][];
		int[][] b;
		int[] c[];
		int [][]d;
		
		int arr[][]={{1,2,3},{4,5,6},{7,8,9}};
		System.out.println("Array length is "+arr.length);
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				System.out.print(arr[i][j]+" ");
			}
	System.out.println();	}
		spiral(arr);
		
		
		//System.out.println("Enter the number of rows");
		//Scanner sc1=new Scanner(System.in);
		//int rows=sc1.nextInt();
		//System.out.println("Lets print Pyramid of stars");
		//pyramidStars(rows);
		//System.out.println("Reverse pyramid for the same");
		//reversePyramidStars(rows);
		//System.out.println(" Rhombus of stars for the same");
		//rhombusStars(rows/2);
		
		System.out.println("Enter the Sidelength of Hollow Square");
		Scanner sc1=new Scanner(System.in);
		int len=sc1.nextInt();
		hollowSquare(len);
	
	}
	public static void hollowSquare(int len){
		for(int i=1;i<=len;i++){
			for(int j=1;j<=len;j++){
				if(i==1 || i==len || j==1 || j==len)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println("");
		}
	}
	public static void pyramidStars(int rows){
		for(int row=1;row<=rows;row++){
			
			for(int colspace=(rows-row);colspace>=1;colspace--){
				System.out.print(" ");
			}
			for(int colstar=1;colstar<=((row*2)-1);colstar++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void reversePyramidStars(int rows){
		for(int row=rows;row>=1;row--){
			
			for(int colspace=(rows-row);colspace>=1;colspace--){
				System.out.print(" ");
			}
			for(int colstar=((row*2)-1);colstar>=1;colstar--){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void rhombusStars(int rows){
		for(int row=1;row<=rows;row++){
			
			for(int colspace=(rows-row);colspace>=1;colspace--){
				System.out.print(" ");
			}
			for(int colstar=1;colstar<=((row*2)-1);colstar++){
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int row=rows-1;row>=1;row--){
			
			for(int colspace=(rows-row);colspace>=1;colspace--){
				System.out.print(" ");
			}
			for(int colstar=((row*2)-1);colstar>=1;colstar--){
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	public static void spiral(int [][]a){
		int dir=0;
		
		int T=0;
		int B=a.length-1;
		int L=0;
		int R=a.length-1;
		int i;
		while(T<=B && L<=R){
			if(dir==0){
				for(i=L;i<=R;i++){
					System.out.print(a[T][i]+",");
				}
				dir=1;T++;
			}
			else if(dir==1){
				for(i=T;i<=B;i++){
					System.out.print(a[i][R]+",");
				}
				dir=2;R--;
			}
			else if(dir==2){
				for(i=R;i>=L;i--){
					System.out.print(a[B][i]+",");
				}
				dir=3;B--;
			}
			else if(dir==3){
				for(i=B;i>=T;i--){
					System.out.print(a[i][L]+",");
				}
				L++;
				dir=(dir+1)%4;
			}
			
			
			
		}
		
		
	}

}
