package Maths;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.List;

import com.google.common.base.Function;
import com.google.common.collect.*;

public class LatencyDistribution {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// generate a sorted list of 500 items between 1..100
		BufferedReader in = new BufferedReader(
				new FileReader("H://latency.log"));
		String latencyStr;
		List<Long> latencies = new ArrayList<Long>();

		while ((latencyStr = in.readLine()) != null) {
			if (latencyStr.equals("End"))
				break;
			latencies.add(Long.parseLong(latencyStr));
		}
		
		for(long l:latencies)
			System.out.println(l);

		// final Random rand = new Random();
		// final List<Integer> list = new ArrayList<Integer>();
		// for (int i = 0; i < 500; i++) {
		// list.add(rand.nextInt(500) + 1);
		// }
		Collections.sort(latencies);

		// ////////////////////////

		// specify how big you want each group to be
		final int groupRange = 10;

		// create a multimap
		ListMultimap<Long, Long> map = Multimaps.index(latencies,
				new Function<Long, Long>() {
					public Long apply(Long i) {
						// work out which group the value belongs in
						return (i / groupRange) + (i % groupRange == 0 ? 0 : 1);
					}
				});

		// ///////////////////////

		// print it out for diagnosis
		for (Long key : map.keySet()) {
			List<Long> value = map.get(key);
			System.out.println("Distribution contains " + value.size()
					+ " items from " + value.get(0) + " to "
					+ value.get(value.size() - 1));
		}

	}

}
