package com.gokul.matrix;

public class TestSudoku6cross6 {

	public static void main(String[] args) {

		String[][] array1= {{"1","2","3","4","6","5"},
							{"4","6","5","3","2","1"},
							{"6","4","1","2","5","3"},
							{"3","5","2","1","4","6"},
							{"2","1","6","5","3","4"},
							{"5","3","4","6","1","2"}};
		checkSudoku(array1);
	}
	static boolean foundError=false;
	
	public static void checkSudoku(String[][] strArray){

		//Checking row wise 1 to 6 not repeated
		String str=" ";
		for(int row=0;row<strArray.length;row++){
			for(int col=0;col<strArray.length;col++){
				if(!str.contains(strArray[row][col]))
					str=strArray[row][col]+str;
				
			}
			validateStr(str);
			str=" ";
		}

		//Checking column wise 1 to 6 not repeated
		for(int col=0;col<strArray.length;col++){
			for(int row=0;row<strArray.length;row++){
				if(!str.contains(strArray[row][col]))
					str=str+strArray[row][col];
			}
			validateStr(str);
			str=" ";
		}
		int count=0;
		int a=0;
		int b=2;
		int c=0;
		int d=3;
		int flow=1;
		while(count<3 && flow<3){
			for(int row=a;row<b;row++){
				for(int col=c;col<d;col++){
					if(!str.contains(strArray[row][col]))
						str=str+strArray[row][col];	
				}
			}
			validateStr(str);
			count++;
			if(count<3){
				a+=2;
				b+=2;}
			else
			{
				flow++;
				a=0;
				b=2;
				c=3;
				d=6;
				count=0;
			}
			str=" ";
		}
		if(foundError==false)
			System.out.println("Your Sudoku looks Good...!!!");

	}
	public static void validateStr(String str){
		if(foundError==false){
			str=str.trim();
			if(str.length()!=6){
				System.out.println("Sudoku number repeated/Missed.Please check ");
				foundError=true;
			}
			else if(str.length()==6 && foundError==false)
			{
				String content="123456";
				for(char c:str.toCharArray()){
					if(!content.contains(c+""))
					{System.out.println("Non-sudoku letters found.Please check ");
					foundError=true;
					}
				}
			}
		}

	}
}


