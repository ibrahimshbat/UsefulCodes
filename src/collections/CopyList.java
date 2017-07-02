package collections;

import java.util.ArrayList;
import java.util.List;

public class CopyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		List<String> names1 = new ArrayList<String>();
//		names1.add("AAA1");
//		names1.add("AAA2");
//		names1.add("AAA3");
//		System.out.println(names1);
//		List<String> names2 = new ArrayList<String>(names1);
//		names2.add("AAA4");
//		System.out.println("names1="+names1);
//		System.out.println("names2="+names2);
		
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
//		names1.add("AAA11");
//		names1.add("AAA12");
//		names1.add("AAA13");
//		names1.add("AAA14");
//		names1.add("AAA15");
//		names1.add("AAA16");
//		names1.add("AAA17");
//		names1.add("AAA18");
//		names1.add("AAA19");
//		names1.add("AAA20");

		//List<String> ss = names1.subList(0, 7);
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
//		double v=9.4;
//		String sval = String.valueOf(v);
//		System.out.println("subList="+sval);
		
		

		
		

	}

}
