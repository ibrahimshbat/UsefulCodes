package randomusingtwovalues;

import java.util.Random;

public class RandomFromTwoValues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random r = new Random();
//		byte Zab=1,ZabCT=2,c;
//		for (int i = 0; i < 10; i++) {
//			c = r.nextBoolean()?Zab:ZabCT;	
//			if (c==Zab)
//				System.out.println("Zab");
//			else
//				System.out.println("ZabCT");
//
//
//		}
		double min =0.1, max =1.0;
		for (int i = 0; i < 100; i++) {
		System.out.println((r.nextInt((int)((max-min)*10+1))+min*10) / 10.0);
		}

	}

}
