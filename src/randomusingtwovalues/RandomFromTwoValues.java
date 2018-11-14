package randomusingtwovalues;

import java.util.Random;
 /*
  * Class to demonstrate generating random value between two points
  */
public class RandomFromTwoValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
		double min =0.1, max =1.0;
		for (int i = 0; i < 100; i++) {
		System.out.println((r.nextInt((int)((max-min)*10+1))+min*10) / 10.0);
		}

	}

}
