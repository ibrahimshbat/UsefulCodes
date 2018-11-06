package maths;

import java.util.Random;

/*
 * Class uses random class to print test double random value
 */
public class TestRandom {

	public static void main(String[] args) {

		final double  PROP = 0.634;//0.5;//0.6339745962155613;//1.0;//
		double randomValue;
		Random random = new Random();
		boolean sendAck = false;
		randomValue=random.nextDouble();
		System.out.println(randomValue);
		randomValue=random.nextDouble();
		System.out.println(randomValue);
		randomValue=random.nextDouble();
		System.out.println(randomValue);

	}

}
