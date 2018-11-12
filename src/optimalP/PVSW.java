package optimalP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Class uses to help ploting the W VS P  (V1)
 */
public class PVSW {

	public static void main(String[] args) throws IOException {
		String str=null; 
		BufferedReader in = new BufferedReader(new FileReader("D:/dl.csv"));
		PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/dlPW.csv",true)));
		TreeMap<Double, Double> pW = new TreeMap<Double, Double>();
		DecimalFormat roundValue = new DecimalFormat("#.000");
		SortedSet<Double> pE1 = new TreeSet<Double>();
		ProtocolStats1 st = new ProtocolStats1();
		int N=9, C=3;
		for (double i = 1; i >= 0.001; i-=0.01) {
			//System.out.println(i);
			i = Double.parseDouble(roundValue.format(i));
			pW.put(i, st.findWForRangep(i,N,C));
		}
		for(double p: pW.keySet())
			outFile.println(""+p+","+pW.get(p));
		outFile.close();
	}
}
