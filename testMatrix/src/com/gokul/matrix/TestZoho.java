package com.gokul.matrix;

public class TestZoho {

	public static void main(String[] args) {
		int[][] givenMatrix={{1,2,3},{4,-8,20}};
		System.out.println("Sum of Elements in the matrix is "+matrixElementsSum(givenMatrix));

	}
	/*public static int matrixElementsSum(int[][] matrix) {
		int sum=0;
		//Traversing 2D using For-Each Loop
		//Matrix to 1D array
		for(int[] array:matrix){
			// 1D Array to number
			for(int number:array){
				sum=number+sum;
			}
		}
		return sum;
	}*/
	public static int matrixElementsSum(int[][] matrix) {
		int sum=0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[i].length;j++){
				sum=sum+matrix[i][j];
			}
		}
		return sum;
		}

}
