package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SumLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer,List<Integer>> allInfos = new TreeMap<Integer,List<Integer>>();
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		l1.add(1);
		l1.add(1);
		l1.add(1);
		l1.add(1);
		l2.add(1);
		l2.add(1);
		l2.add(1);
		l2.add(1);
		l3.add(1);
		l3.add(1);
		l3.add(1);
		l3.add(1);
		l4.add(1);
		l4.add(1);
		l4.add(1);
		l4.add(1);
		
		allInfos.put(1, l1);
		allInfos.put(2, l2);
		allInfos.put(3, l3);
		allInfos.put(4, l4);
		
		List<Integer> style = new ArrayList<Integer>();

		style.addAll(l1);
		style.addAll(l1);
		style.addAll(l1);
		style.addAll(l1);
		System.out.println(style);

//		Collections.addAll(c, elements)
//		List<Integer> first = new ArrayList<Integer>(allInfos.get(1));
//		List<Integer> next = new ArrayList<Integer>();
//		
//
//		System.out.println(allInfos.size());
//		System.out.println(l1.size());
//
//
//		for (int i = 2; i < allInfos.size(); i++) {
//			next = allInfos.get(i);
//			System.out.println("i="+i);
//			for (int j = 0; j < l1.size(); j++) {
//				System.out.println(""+(first.get(j) + "-"+( next.get(j))));
//				first.add(j, (first.get(j) + next.get(j)));
//			}
//			first.
//
//		}
//		System.out.println(first);


	}

}
