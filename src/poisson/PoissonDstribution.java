package poisson;

import java.util.Random;

/*
 * Class uses Poisson distribution
 */
public class PoissonDstribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println(getPoissonRandom(400));
		System.out.println("------------------");
		System.out.println(poisson(400));
		System.out.println(poisson(400));
		System.out.println(poisson(400));
		System.out.println(poisson(400));
		System.out.println(poisson(400));
		System.out.println(poisson(400));
		System.out.println(poisson(400));
		System.out.println(poisson(400));

	}
	
	private static int getPoissonRandom(double mean) {
	    Random r = new Random();
	    double L = Math.exp(-mean);
	    int k = 0;
	    double p = 1.0;
	    do {
	        p = p * r.nextDouble();
	        k++;
	    } while (p > L);
	    return k - 1;
	}
	
	private static int poisson(double mean) {
	    int r = 0;
	    Random random = new Random();
	    double a = random.nextDouble();
	    double p = Math.exp(-mean);

	    while (a > p) {
	        r++;
	        a = a - p;
	        p = p * mean / r;
	    }
	    return r;
	}

}
