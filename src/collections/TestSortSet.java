package collections;

import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class TestSortSet {

	public static void main(String[] args) {
		ConcurrentMap<Long, String> outstandingProposals = new ConcurrentHashMap<Long, String>();
		outstandingProposals.put((long)3, "A");
		outstandingProposals.put((long)4, "B");
		outstandingProposals.put((long)1, "C");
		outstandingProposals.put((long)2, "D");
		outstandingProposals.put((long)11, "D");
		Set<Long> committable = new TreeSet<Long>(outstandingProposals.keySet());
		outstandingProposals.put((long)12, "D");
		outstandingProposals.remove((long)1);
		System.out.println(outstandingProposals);
		System.out.println(committable);
		System.out.println();
		committable.remove((long)2);
		System.out.println(outstandingProposals);
		System.out.println(committable);
		
		committable.clear();
		System.out.println(outstandingProposals);
		System.out.println(committable);



	}

}
