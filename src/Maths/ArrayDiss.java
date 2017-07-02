package Maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class ArrayDiss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		List<Long> items = new ArrayList<Long>();
		for (int i = 0; i < 20; i++) {
			items.add(r.nextLong());
		}

		List asList = Arrays.asList(items);
		Set<String> mySet = new HashSet<String>(asList);
		for(String s: mySet){		
		 System.out.println(s + " " +Collections.frequency(asList,s));
		
		}


	}

}
