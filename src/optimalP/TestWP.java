package optimalP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Class uses to help ploting the W VS P (V2)
 */
public class TestWP {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ProtocolStats1 ps = new ProtocolStats1();
		
		String str=null; 
		BufferedReader in = new BufferedReader(new FileReader("D:/dl.csv"));
		PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/dlPW.csv",true)));
		TreeMap<Double, Double> pW = new TreeMap<Double, Double>();
		DecimalFormat roundValue = new DecimalFormat("#.000");
		SortedSet<Double> pE1 = new TreeSet<Double>();
		ProtocolStats1 st = new ProtocolStats1();
		int N=9, C=0;
		ArrayList<Double> P1us = new ArrayList<Double>();
		ArrayList<Double> P1ls = new ArrayList<Double>();
		double P1u=0.0, P1l=0.0, WP1u=0.0, WP1l=0.0;
		while ((str = in.readLine()) != null){
			//System.out.println(str);
			P1u = Double.parseDouble(str.split(",")[0]);
			P1l = Double.parseDouble(str.split(",")[1]);
			WP1u= ps.findWForRangep(P1u,N,0);
			WP1l= ps.findWForRangep(P1l,N,0);
			//pW.put(P1u, P1l);
			P1us.add(WP1u);
			P1ls.add(WP1l);

		}
		System.out.println(P1us);
		System.out.println(P1ls);
		for(int i=0;i<P1us.size();i++)
			outFile.println(P1us.get(i)+","+P1ls.get(i));

		outFile.close();
			

	}

}
