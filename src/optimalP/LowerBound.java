package optimalP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.SortedSet;
import java.util.TreeSet;

/*
 * Class helps to find a reasnobale P for ZabCT protocol
 */
public class LowerBound {

	public static void main(String[] args) throws NumberFormatException, IOException {
		String str=null; 
		BufferedReader in = new BufferedReader(new FileReader("D:/dl.csv"));

		DecimalFormat roundValue = new DecimalFormat("#.000");
		SortedSet<Double> pE1 = new TreeSet<Double>();
		ProtocolStats1 st = new ProtocolStats1();
		double delta = 0.001;
		int N=7,WR=10;
		double 	dlamda=26.36, P2=0.269,p=0.0,P1=0.0,p1u=0.0,pw=0.0,minVal=0.0;
		for (double i = 0.01; i <= 1; i+=0.01) {
			i = Double.parseDouble(roundValue.format(i));
			pw=st.findWForRangep(i,N,0);

			if(pw<dlamda){
				p1u=i;
				break;
			}
		}
		//minVal=Math.min(P2, p1u);
		P1=findp(0,6,0.96,0.312, st);
		System.out.println("dsdsd"+P1);
	}
	public static double findp(int c, int n, double c1, double min, ProtocolStats1 st){
		final double ABS = 0.001;
		DecimalFormat roundValue = new DecimalFormat("#.000");
		double newp=min, newW=0.0, newWok=0.0,p=11.0, upto=min-0.01;
		boolean start =true;
		while(start && newp>upto){
			newp=Double.parseDouble(roundValue.format(newp));
			newW = st.findWForRangep(newp, n+1, c);
			System.out.println("W(P)="+newW+" P="+newp+" dLamda="+c1);
			if (newW<c1){	
				p=newp;
				newWok=newW;
				newp= newp- ABS;
			}
			else{
				start=false;
				System.out.println("W(P)="+newWok+" p="+p+" dLamda="+c1);
			}

			//System.out.println(st.findWForRangep(c2, n+1, c);
			//log.info("check newp="+newp);
		}
		//System.out.println("W(P)="+newW+" P="+newp+" dLamda="+c1);

		return p;
	}


}
