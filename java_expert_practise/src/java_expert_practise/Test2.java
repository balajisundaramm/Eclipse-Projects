package java_expert_practise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class Test2 {

	public static void main(String[] args) {
		int[] nums={10,36,54,89,12};
		Map<Integer, Integer> map=new TreeMap<>();
		for(int a:nums){
			int wt=0;
			double d=Math.sqrt((double)a);
			if((a&1)==0)
				wt=3;
			if(a%4==0 && a%6==0)
				wt=wt+4;
			if(((int)d)*((int)d)==a)
				wt=wt+5;
			map.put(a, wt);	
		}
		ValueComparator bvc = new ValueComparator(map);
        TreeMap<Integer, Integer> sorted_map = new TreeMap<Integer, Integer>(bvc);

        System.out.println("unsorted map: " + map);
        sorted_map.putAll(map);
        System.out.println("results: " + sorted_map);
        System.out.println("***********");
		System.out.println(map.entrySet());
		System.out.println(map.values());
	}
	}
class ValueComparator implements Comparator<Integer> {
    Map<Integer, Integer> base;

    public ValueComparator(Map<Integer, Integer> base) {
        this.base = base;
    }
	@Override
	public int compare(Integer o1, Integer o2) {
		if (base.get(o1) <= base.get(o2)) {
            return -1;
        } else {
            return 1;
        }
	}


}

