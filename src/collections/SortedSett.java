package collections;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;


public class SortedSett {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final SortedSet<Long> items= Collections.synchronizedSortedSet(new TreeSet<Long>());
		items.add((long)8);
		items.add((long)6);
		items.add((long)3);
		items.add((long)2);
		System.out.println("size before="+items.size());
		long f=items.first();
		items.remove(f);
		System.out.println("First items="+f);
		System.out.println("size after edit="+items);




	}

}
