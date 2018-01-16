package com.gokul.matrix;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestPropellante {

	public static void main(String[] args) {
		String str = "I'm coming out raw... my game is beyond pain.. game is life ";
		Set<String> set = new LinkedHashSet<>();
		ArrayList<String> list = new ArrayList<String>();
		for (String s : str.split(" ")) {
			list.add(s);
			set.add(s);
		}

		System.out.println("Total number of words in the sentence are " + str.split(" ").length);
		System.out
				.println("Total number of Duplicate words in the sentence are " + (str.split(" ").length - set.size()));
		System.out.println("sentence after removal");
		for (String s : set) {
			System.out.print(s + " ");
			list.remove(s);
		}
		System.out.println("");
		System.out.println("Duplicate Words are");
		for (String s : list) {
			System.out.print(s + " ");
		}

	}

}
