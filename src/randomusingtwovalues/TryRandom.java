package randomusingtwovalues;

import java.util.Random;

public class TryRandom {

	public static void main(String[] args) {
		int countSeqNotAck=0;
		int countTotal = 0;
		for (int i = 1; i <= 550000; i++) {
			boolean isCommited = willCommit();
			if(isCommited){
				if (countSeqNotAck>=250){
					countTotal++;
					System.out.println("countSeqNotAck "+countSeqNotAck);
				}
				countSeqNotAck=0;
			}
			else{
				countSeqNotAck++;
			}
		}
		System.out.println("countTotal "+countTotal);
	}
	public static boolean willCommit(){
		double p=0.130;
		Random random = new Random();
		int countACK=0;
		for (int i = 1; i <= 6; i++) {
			double d = random.nextDouble();
			if(d<=p){
				++countACK;
			}
		}
		if(countACK>=3)
			return true;
		else
			return false;

	}

}
