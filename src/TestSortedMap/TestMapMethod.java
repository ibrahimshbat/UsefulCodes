package TestSortedMap;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class TestMapMethod {

	public static void main(String[] args) {
		ConcurrentMap<Integer, Integer> f = new ConcurrentHashMap<Integer, Integer>();
		f.put(1, 20);
		f.put(2, 21);
		f.put(3, 22);
		f.put(4, 23);
		System.out.println("before-->"+f);
		int d = f.remove(3);
		System.out.println("after-->"+f);
		System.out.println("d-->"+d);




	}

}
