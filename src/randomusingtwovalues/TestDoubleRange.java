package randomusingtwovalues;

import java.util.Random;

import com.google.common.util.concurrent.AtomicDouble;

public class TestDoubleRange {

	public static void main(String[] args) {
//		Random random = new Random();
//		double d = random.nextDouble();
//		System.out.println(d);
//		if(d<0.2239)
//			System.out.println("Less");
//		else
//			System.out.println("Large");
		
		AtomicDouble n = new AtomicDouble(0.0);
		System.out.println(n);
		n.set(0.3);
		System.out.println(n);


	}

}
