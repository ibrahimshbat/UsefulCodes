package Lambda;

import java.util.Comparator;

public class LambdaEX1 {

	public static void main(String[] args) {
//		Comparator<String> ccomparsion = new Comparator<String>() {
//			@Override
//			public int compare(Object o1, Object o2) {
//				return ((String) o1).compareTo((String) o2);
//			}
//		};
//		
		Comparator<String> comparsionLambda = 
			(String o1, String o2) -> {return o1.compareTo(o2);};

	}

}
