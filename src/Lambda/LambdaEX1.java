package Lambda;



import java.util.Comparator;

import MyComparator;
import MyFactory;
import MyFuction;


public class LambdaEX1 {

	public static void main(String[] args) {
//		Comparator<String> ccomparsion = new Comparator<String>() {
////			@Override
////			public int compare(Object o1, Object o2) {
////				return ((String) o1).compareTo((String) o2);
////			}
//
//			@Override
//			public int compare(String o1, String o2) {
//				return ((String) o1).compareTo((String) o2);
//			}
//		};
//		
//		Comparator<String> comparsionLambda = 
//			(o1,  o2) ->  o1.compareTo(o2);
//			
//		int com1 = ccomparsion.compare("Hello", "World");
//		System.out.println(com1);
//		int com2 = comparsionLambda.compare("Hello", "World");
		//MyFuction myFunction = () -> {System.out.println("Hellp Ibrahim");};
		MyFuction myFunction = (t1,t2) -> t1 + " " + t2;
		System.out.println(myFunction.apply("Hellp Ibrahim", "EL-Sanosi"));
		
		MyFuction myFunction2 =myFunction;
		String apply = myFunction2.apply("Hello Muhammad", "EL-Sanosi");
		System.out.println(apply);
		
		
		//MyComparator myComparator = (a1,a2) -> return a1 > a2;
		MyComparator myCom = (a1,a2) ->  a1>a2;
		boolean result = myCom.compare(6, 5);
		System.out.println(result);
		
		MyFactory myFactory = (chars) -> {
		    return new String(chars);
		};
		
		String myString = "Test";

//		MyFactory myFactory = (chars) -> {
//		      "" + myString + ":" + new String(chars);
//		};

				

	}

}
