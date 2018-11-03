package maths;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;
/*
 * Class uses to group and anaylsis latancy data
 */
public class LatencyDistribution1 {
	public static void main(String[] args) throws IOException {
		// initialize the List with 500 random values between 1 and 200
		// you'll probably supply your existing lists instead

		BufferedReader in = new BufferedReader(
				new FileReader("/Zab2Phases/latency.log"));
		String latencyStr;
		List<Double> latencies = new ArrayList<Double>();

		while ((latencyStr = in.readLine()) != null) {
			if (latencyStr.equals("End"))
				break;
			latencies.add( (double) ((Double.parseDouble(latencyStr))/1000000));
		}
		System.out.println("latencies size="+latencies.size());
		
//		final Random rand = new Random();
//		final List<Integer> list = new ArrayList<Integer>();
//		for (int i = 0; i < 500; i++) {
//			list.add(rand.nextInt(200) + 1);
//		}

		// create a multiset
		final Multiset<Double> multiset = TreeMultiset.create(latencies);

		// create 10 partitions of entries
		// (each element value may appear multiple times in the multiset
		// but only once per partition)
		final Iterable<List<Double>> partitions = Iterables.partition(
				multiset.elementSet(),
				// other than aioobe, I create the partition size from
				// the number of unique entries, accounting for gaps in the list
				multiset.elementSet().size() / 10);

		int partitionIndex = 0;
		for (final List<Double> partition : partitions) {

			// count the items in this partition
			int count = 0;
			for (final Double item : partition) {
				count += multiset.count(item);
			}
			System.out.println("Partition " + ++partitionIndex + " contains "
					+ count + " items (" + partition.size() + " unique) from "
					+ partition.get(0) + " to "
					+ partition.get(partition.size() - 1));
		}

	}
}