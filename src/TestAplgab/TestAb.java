package TestAplgab;

import java.text.DecimalFormat;
import java.util.SortedSet;
import java.util.TreeSet;


public class TestAb {

	public static void main(String[] args) {
		RangeHead rh = new RangeHead(1,2);
		DecimalFormat roundValue = new DecimalFormat("#.000");
		double term1=1,p=0;
		SortedSet<Double> ps = new TreeSet<Double>();
		//for (RangeHead rangeHead : rangeHeads) {
			term1=1;
			for (int j = 0; j <= rh.getB(); j++) {
				term1*= ((double)((4-rh.getAlpha())-j)) / ((double)(rh.getAlpha()+j));				
			}
			term1=1+Math.pow(term1, ((double)1/((double) rh.getB()+1)));
			p = ((double)1) / ((double) term1);
			p= Double.parseDouble(roundValue.format(p));
			System.out.println(p);

	}

}
