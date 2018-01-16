package com.gokul.matrix;

public class TestZohoVowels {

	public static void main(String[] args) {
		char[] charArray={'G','O','O','d',' ','m','O','r','n','I','n','g'};
		checkNonConsecutiveVowels(charArray);
		
	}
	
		public static void checkNonConsecutiveVowels(char[] charArray){
			int count=0; boolean flag=false;
			for(int i=0;i<charArray.length;i++){
				if(charArray[i]=='A')
					charArray[i]='a';
				else if(charArray[i]=='E')
					charArray[i]='e';
				else if(charArray[i]=='I')
					charArray[i]='i';
				else if(charArray[i]=='O')
					charArray[i]='o';
				else if(charArray[i]=='U')
					charArray[i]='u';
			}
			for(int i=1;i<charArray.length-1;i++){
				if((charArray[i+1]!='a' && charArray[i+1]!='e' && charArray[i+1]!='i' && charArray[i+1]!='o' && charArray[i+1]!='u') 
					&& (charArray[i-1]!='a' && charArray[i-1]!='e' && charArray[i-1]!='i' && charArray[i-1]!='o' && charArray[i-1]!='u'))
					{
					if((charArray[i]=='a' || charArray[i]=='e' || charArray[i]=='i' || charArray[i]=='o' || charArray[i]=='u'))
						count++;		
					}
			}
			System.out.println("Number of Non consecutive vowels are "+count);
		}

	}


