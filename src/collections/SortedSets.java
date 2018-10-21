package collections;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Class to Use SortedSet and Collections.synchronizedSortedSet classes to sort items
 */
public class SortedSets {

	public static void main(String[] args) {
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
