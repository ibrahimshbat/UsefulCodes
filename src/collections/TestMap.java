package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMap {
	public static void main(String[] args) {
		Map<Integer, List<String>> averageL = new HashMap<Integer, List<String>>();
		averageL.put(10, new ArrayList<String>());
		averageL.get(10).add("sfsdf");
		System.out.println(averageL);
	}

}
