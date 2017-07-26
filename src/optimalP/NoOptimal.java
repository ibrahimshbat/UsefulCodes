package optimalP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.SortedSet;
import java.util.TreeSet;

public class NoOptimal {

	public static void main(String[] args) throws IOException {
		String str=null; 
		BufferedReader in = new BufferedReader(new FileReader("D:/dl.csv"));

		DecimalFormat roundValue = new DecimalFormat("#.000");
		SortedSet<Double> pE1 = new TreeSet<Double>();
		ProtocolStats st = new ProtocolStats();
		double delta = 0.001;
		int N=5,WR=10;
		double 	dlamda=0.0, E2=0.25,p=0.0,pp=0.0;
		while ((str = in.readLine()) != null){
			dlamda = Double.parseDouble(str);
			for (double i = 1; i >= 0.05; i-=0.05) {
				//System.out.println(i);
				i = Double.parseDouble(roundValue.format(i));
				if(st.findWForRangep(i,N,0)<dlamda){
					pE1.add(i);
				}
			}
			if (pE1.first() < E2){
				p=E2-delta;
				System.out.println("WR=+"+WR+"/P1*="+pE1.first()+"/P1*<=E2/ ---> p="+p);
			}
			else{
				System.out.println("pE1.first()="+pE1.first());
				pp=findp(0,4,dlamda,E2,pE1.first(),st);
				if(pp!=0.0)
					System.out.println("WR=+"+WR+"/P1*="+pE1.first()+"/P1*<=E2/ ---> p="+pp);
				else
					System.out.println(" NOT ** pE1.first() <= E2");
			}
			WR+=10;
		}
	}

	public static double findp(int c, int n, double c1, double c2, double P1, ProtocolStats st){
		final double ABS = 0.001;
		DecimalFormat roundValue = new DecimalFormat("#.000");
		double newp=c2, newW=0.0, p=0.000, upto=P1-0.05;
		boolean start =true;
		while(start && newp>upto){
			newp=Double.parseDouble(roundValue.format(newp));

			newW = st.findWForRangep(newp, n+1, c);
			System.out.println("W(P)="+newW+" P="+newp);
			if (newW<c1){	
				p=newp;
				newp= newp- ABS;
			}
			else
				start=false;
			
			//System.out.println(st.findWForRangep(c2, n+1, c);
			//log.info("check newp="+newp);
		}
		return p;
	}

}
