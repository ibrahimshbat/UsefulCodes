package maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.*;
public class ArrayDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//generate a sorted list of 500 items between 1..100
		final Random rand = new Random();
		final List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 500; i++) {
		    list.add(rand.nextInt(500) + 1);
		}
		Collections.sort(list);

		//////////////////////////

		//specify how big you want each group to be
		final int groupRange = 50;

		//create a multimap
		ListMultimap<Integer, Integer> map = Multimaps.index(list, new Function<Integer, Integer>() {
		    public Integer apply(Integer i) {
		        //work out which group the value belongs in
		        return (i / groupRange) + (i % groupRange == 0 ? 0 : 1);
		    }
		});

		/////////////////////////

		//print it out for diagnosis
		for (Integer key : map.keySet()) {
		    List<Integer> value = map.get(key);
		    System.out.println("Distribution contains " + value.size() + " items from " + value.get(0) + " to " + value.get(value.size() - 1));
		}
		

	}

}
