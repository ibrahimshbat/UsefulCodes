package collections;

import java.util.ArrayList;
import java.util.List;
/*
 * Class to show an example of copying list to a new list
 */
public class CopyList {

	public static void main(String[] args) {
		List<String> names1 = new ArrayList<String>();
		names1.add("AAA1");
		names1.add("AAA2");
		names1.add("AAA3");
		names1.add("AAA4");
		names1.add("AAA5");
		names1.add("AAA6");
		names1.add("AAA7");
		names1.add("AAA8");
		names1.add("AAA9");
		names1.add("AAA10");

		System.out.println("subList="+names1.size());
		int size = names1.size()/4;
		int index =0;
		System.out.println("List1="+names1.subList(index, (index + size)));
		index += (size);
		System.out.println("List2="+names1.subList(index, (index + size)));
		index += (size);
		System.out.println("List3="+names1.subList(index, (index + size)));
		index += (size);
		System.out.println("List4="+names1.subList(index, (index + size)));

	}

}
