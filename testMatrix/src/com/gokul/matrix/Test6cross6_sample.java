package com.gokul.matrix;

public class Test6cross6_sample {

		public static void main(String[] args) {
			String[][] array1= {{"1","2","3","4","5","6"},
					            {"6","z","4","3","3","1"},
					            {"5","4","1","2","6","3"},
					            {"3","6","2","1","4","5"},
					            {"2","1","5","6","3","4"},
					            {"4","3","6","5","1","2"}};
			checkSudoku(array1);
		}
		public static void validateStr(String str){
			str=str.trim();
			//System.out.println(str.trim().length());
			if(str.trim().length()!=6){
				System.out.println("Sudoku number repeated in row number ");
			}
			else if(str.length()==6)
			{
				String content="123456";
				for(char c:str.toCharArray()){
					if(!content.contains(c+""))
						System.out.println("Non-sudoku letters found in row number ");
				}
			}
			
		}
			public static void checkSudoku(String[][] strArray){
			//Checking row wise 1 to 6 not repeated
				String str=" ";
			for(int row=0;row<strArray.length;row++){
				for(int col=0;col<strArray.length;col++){
					//System.out.print(strArray[row][col]);
					 if(!str.contains(strArray[row][col]))
						 str=strArray[row][col]+str;
					 //System.out.println(str);
				}
				validateStr(str);
				str=" ";
				//System.out.println();
			}
			
			//Checking column wise 1 to 6 not repeated
		for(int col=0;col<strArray.length;col++){
			for(int row=0;row<strArray.length;row++){
				//System.out.print(strArray[row][col]);
				 if(!str.contains(strArray[row][col]))
					 str=str+strArray[row][col];
				 //System.out.println(str);
			}
			//System.out.println(str.trim().length());
			str=str.trim();
			if(str.trim().length()!=6){
				System.out.println("Sudoku number repeated in Column number "+(col+1));
			}
			else if(str.length()==6)
			{
				String content="123456";
				for(char c:str.toCharArray()){
					if(!content.contains(c+""))
						System.out.println("Non-sudoku letters found in Column number "+(col+1));
				}
			}
			
			str=" ";
			//System.out.println();
		}
		int count=0;
		int i=0;
		int b=2;
		int c=0;
		int d=3;
		int flow=1;
		while(count<3 && flow<3){
			for(int row=i;row<b;row++){
				for(int col=c;col<d;col++){
					if(!str.contains(strArray[row][col]))
					str=str+strArray[row][col];	
				}
				str=str.trim();
				//System.out.println(str.trim().length());
				 if(str.length()==6)
				{
					String content="123456";
					for(char c1:str.toCharArray()){
						if(!content.contains(c1+""))
							System.out.println("Non-sudoku letters found");
					}
				}
			}
			System.out.println(str);
			count++;
			if(count<3){
			i+=2;
			b+=2;}
			else
			{
				flow++;
				i=0;
				b=2;
				c=3;
				d=6;
				count=0;
			}
			str=" ";
		}
		

	}
		}





