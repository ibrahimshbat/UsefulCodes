package TestSortedMap;

import java.util.HashMap;
import java.util.Map;

public class TestHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Double, Integer> latencyPerRatio = new HashMap<Double, Integer>();
		latencyPerRatio.put(0.5, 4);
		latencyPerRatio.put(0.2, 10);
		System.out.println(latencyPerRatio);

	}

}
