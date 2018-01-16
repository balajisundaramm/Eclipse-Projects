package com.gokul.matrix;

import java.util.Arrays;

public class TestAnagram {
	//Anagram--> a word, phrase, or name formed by rearranging the letters of another,
	//such as spar, formed from rasp.

	public static void main(String[] args) {
		String s1="silent";
		String s2="listen";
		
		//Removing all white spaces from s1 and s2
        s1 = s1.toLowerCase().replaceAll("\\s+", "");
        System.out.println(s1);
        s2 = s2.toLowerCase().replaceAll("\\s+", "");
        System.out.println(s2);
		
		char[] c1=s1.toCharArray();
		char[] c2=s2.toCharArray();
		Arrays.sort(c1);
		Arrays.sort(c2);
		//System.out.println(c1);
		//System.out.println(c2);
		validateAnagram(c1,c2);
	
	}
	public static void validateAnagram(char[] c1,char[]c2){
		int count=c1.length-c2.length;
		if(count==0)
		{
			for(int i=0;i<c1.length;i++){
				if(c1[i]!=c2[i])
					count++;
			}
		}
		if(count==0)
			System.out.println("Given two words are Anagram");
		else
			System.out.println("Given two words are Not Anagram");
	}
}
/*isAnagram("Mother In Law", "Hitler Woman");
isAnagram("keEp", "peeK");
isAnagram("SiLeNt CAT", "LisTen AcT");
isAnagram("Debit Card", "Bad Credit");
isAnagram("School MASTER", "The ClassROOM");
isAnagram("DORMITORY", "Dirty Room");
isAnagram("ASTRONOMERS", "NO MORE STARS");
isAnagram("Toss", "Shot");
isAnagram("joy", "enjoy");*/
