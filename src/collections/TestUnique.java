package collections;

import java.util.HashSet;
import java.util.Set;

/*
 * Class to test items stored in Set collection
 */
public class TestUnique {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Set<String> addresses = new HashSet<String>();
		addresses.add("addr1");
		addresses.add("addr1");
		addresses.add("addr1");
		addresses.add("addr2");
		addresses.add("addr2");

		System.out.println(addresses);
	}


}
