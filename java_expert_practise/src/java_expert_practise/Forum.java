package java_expert_practise;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Forum{

public static void main (String[] args)
	
{	
	Movies mov1=new Movies(01,"kodi",2019);
	Movies mov2=new Movies(11,"kala",2021);
	Movies mov3=new Movies(04,"citizen",2000);
	Movies mov4=new Movies(9,"muthu",1967);
	Movies mov5=new Movies(21,"billa",2000);
	ArrayList<Movies> movList=new ArrayList<Movies>();
	movList.add(mov5);
	movList.add(mov4);
	movList.add(mov3);
	movList.add(mov2);
	movList.add(mov1);
	
	IdCompare idCompare=new IdCompare();
	NameCompare NameCompare=new NameCompare();
	System.out.println("*****Comparable-->overrided compareto method--based on year****");
	Collections.sort(movList);
	for(Movies s : movList){
		System.out.println(s);
	}
	System.out.println(" ");
	Collections.sort(movList, idCompare);
	System.out.println("*****separate class idcompare-->overrided COMPARE method--based on id****");
	for(Movies s : movList){
		System.out.println(s);
	}
	System.out.println(" ");
	System.out.println("*****separate class namecompare-->overrided COMPARE method--based on name****");
	Collections.sort(movList, NameCompare);
	for(Movies s : movList){
		System.out.println(s);
	}
	movList.size();
	ArrayList list=new ArrayList();
	ArrayList<String> list1=new ArrayList<String>();
	list1.add("z");
	list1.add("A");
	list1.add("N");
	list1.add("D");
	list1.add("Z");
	Collections.sort(list1);
	System.out.println(" ");
	System.out.println("String implemented comparable---overided comapare to");
	for(String s : list1){
		System.out.println(s);
	}
}
}
