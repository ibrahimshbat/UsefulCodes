import java.util.Random;


public class TestRandom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random rand = new Random();
		int min = 75, max = 125, randomNum=0;
		for (int i = 0; i < 10; i++) {
			randomNum = min + rand.nextInt((max - min) + 1);
			System.out.println(randomNum);
		}

	}

}
