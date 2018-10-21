package collections;

import java.util.LinkedHashMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/*
 * Class shows how to use ConcurrentMap and TreeMap collections
 */
public class SortLinkedHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConcurrentMap<Long, String> map1 = new ConcurrentHashMap<Long, String>();
		ConcurrentMap<Long, String> map3 = new ConcurrentHashMap<Long, String>();

		map1.put((long)2, "Salm");
		map1.put((long)1, "Ali");
		map1.put((long)7, "Bader");
		map1.put((long)0, "Ibrahim");

		TreeMap<Long, String> map2 = new TreeMap<Long, String>(map1);
		map2.remove((long)(7));
		System.out.println(map1);
		System.out.println(map2);

	}

}
