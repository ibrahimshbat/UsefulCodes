package subList;
/*
 * Class to Check how to obtain sub list from List
 */
import java.util.ArrayList;
import java.util.List;

public class SubList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<String> names = new ArrayList<String>();
		names.add("Slam");
		names.add("Mabroka");
		names.add("Sagaer");

		List<String> subNames = names.subList(1, 3);
		
		System.out.println(names);
		System.out.println(subNames);

		

	}

}
