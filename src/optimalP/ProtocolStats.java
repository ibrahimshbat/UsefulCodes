package optimalP;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


import com.google.common.collect.Iterables;
import com.google.common.collect.Multiset;
import com.google.common.collect.TreeMultiset;

/*
 * It uses to gathering protocol stats like throughput, latency and load.
 */
public class ProtocolStats {
	private List<Long> latencies;
	private List<Long> readLatencies;
	private List<Double> throughputs;
	private List<Long> recievedRequestTime;
	private List<String> infoForp;
	private int throughput;
	private long startThroughputTime;
	private long endThroughputTime;
	private long lastThroughputTime;
	private String protocolName;
	private int numberOfSenderInEachClient;
	private int numberOfClients;
	private long lastRecievedTime;
	private AtomicInteger numRequest;
	private AtomicInteger numReqDelivered;
	private AtomicInteger lastNumReqDeliveredBefore;
	public AtomicInteger countACKPerBroadcast;
	private static PrintWriter outFile;
	private static PrintWriter outFileToWork;
	private static PrintWriter outFileAllLat;
	private static PrintWriter writeLat;
	private static PrintWriter readLat;
	private static PrintWriter allLat;
	private static PrintWriter allInfoZanCT;
	private static PrintWriter outThroughput;

	public String dirTestType=null;
	public String info=null;
	public AtomicInteger numProposal;
	public AtomicInteger lastNumProposal;
	private String outDir;
	private AtomicInteger countDummyCall;
	private boolean is_warmup = true;
	private List<Integer> numAckPerBroadcast;
	private List<String> results;
	private AtomicInteger countTotalMessagesFollowers;

	//For compare number of Acks between Zab and ZabCT Adaptation
	public AtomicInteger countAckMessage;

	private long startTimeRatio=System.currentTimeMillis();

	private TreeMap<Double, Double> extrapW; //For store more ps if the defult ps table does not work
	public ProtocolStats() {

	}

	

	public double findWForRangep(double p, int N, int c){
		DecimalFormat roundValue = new DecimalFormat("#.000");
		TreeMap<Double, Double> pW = new TreeMap<Double, Double>();
		double q00,q01,q02,q03,q11,q12,q13,q22,q23,q33, W=0.0;
		switch(N){
		case 3:
		{
			switch(c){
			case 0:

				q00=Math.pow((1-p), 2);
				W = ( (double) q00/(double) (1-q00) );
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 1:
				q00=Math.pow((1-p), 1);
				W = ( (double) q00/(double) (1-q00) );
				W= Double.parseDouble(roundValue.format(W));
				break;
			}
		}
		break;
		case 5:
		{
			switch(c){
			case 0:
				q00=Math.pow((1-p), 4);
				q01=(4*p)* (Math.pow((1-p), 3));
				q11=Math.pow((1-p), 3);
				W = (((double) q00)/(double) (1-q00))+  (((double) q01)/((double) (1-q00) * (1-q11)));
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 1:

				q00=Math.pow((1-p), 3);
				q01=(3*p)* (Math.pow((1-p), 2));
				q11=Math.pow((1-p), 2);
				W = (((double) q00)/(double) (1-q00))+  (((double) q01)/((double) (1-q00) * (1-q11)));
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 2:
				q00=Math.pow((1-p), 2);
				q01=(2*p)* (1-p);
				q11=1-p;
				W = (((double) q00)/(double) (1-q00))+  (((double) q01)/((double) (1-q00) * (1-q11)));
				W= Double.parseDouble(roundValue.format(W));

				break;

			}
		}
		break;
		case 7:
		{
			switch(c){
			case 0:
				q00=Math.pow((1-p), 6);
				q01=(6*p)* (Math.pow((1-p), 5));
				q02=(15* (Math.pow(p, 2))) * (Math.pow((1-p), 4));
				q11=Math.pow((1-p), 5);
				q12=(5*p) * (Math.pow((1-p), 4));
				q22=Math.pow((1-p), 4);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11)))
						+ (((double) q01*q12)/((double) (1-q00) * (1-q11) * (1-q22)))
						+ (((double) q02)/(double) (1-q00) * (1-q22)) ;
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 1:
				q00=Math.pow((1-p), 5);
				q01=(5*p) * (Math.pow((1-p), 4));
				q02=(10* (Math.pow(p, 2))) * (Math.pow((1-p), 3));
				q11=Math.pow((1-p), 4);
				q12=(4*p) * (Math.pow((1-p), 3));
				q22=Math.pow((1-p), 3);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11))) 
						+ (((double) q01*q12)/((double) (1-q00) * (1-q11) * (1-q22))) 
						+ (((double) q02)/((double) (1-q00) * (1-q22))) ;
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 2:
				q00=Math.pow((1-p), 4);
				q01=(4*p) * (Math.pow((1-p), 3));
				q02=(6* (Math.pow(p, 2))) * (Math.pow((1-p), 2));
				q11=Math.pow((1-p), 3);
				q12=(3*p) * (Math.pow((1-p), 2));
				q22=Math.pow((1-p), 2);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11))) 
						+ (((double) q01*q12)/((double) (1-q00) * (1-q11) * (1-q22))) 
						+ (((double) q02)/((double) (1-q00) * (1-q22))) ;
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 3:
				q00=Math.pow((1-p), 3);
				q01=(3*p) * (Math.pow((1-p), 2));
				q02=(3* (Math.pow(p, 2))) * (1-p);
				q11=Math.pow((1-p), 2);
				q12=(2*p) * (1-p);
				q22=(1-p);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11))) 
						+ (((double) q01*q12)/((double) (1-q00) * (1-q11) * (1-q22))) 
						+ (((double) q02)/((double) (1-q00) * (1-q22))) ;
				W= Double.parseDouble(roundValue.format(W));
				break;
			}
		}
		break;
		case 9:
		{
			switch(c){
			case 0:
				q00=Math.pow((1-p), 8);
				q01=(8*p) * (Math.pow((1-p), 7));
				q02=(28* (Math.pow(p, 2))) * (Math.pow((1-p), 6));
				q03=(56* (Math.pow(p, 3))) * (Math.pow((1-p), 5));
				q11=Math.pow((1-p), 7);
				q12=(7*p) * (Math.pow((1-p), 6));
				q13=(21* (Math.pow(p, 2))) * (Math.pow((1-p), 5));
				q22=Math.pow((1-p), 6);
				q23=(6*p) * (Math.pow((1-p), 5));
				q33=Math.pow((1-p), 5);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11))) 
						+ (((double) q01*q12)/((double) ((1-q00) * (1-q11) * (1-q22))))
						+ (((double) q01*q12*q13)/((double) ((1-q00) * (1-q11) * (1-q22) * (1-q33))))
						+ (((double) q02)/((double) (1-q00) * (1-q22))) + (((double) q02*q23)/((double) ((1-q00) * (1-q22) * (1-q33))))
						+ (((double) q03)/((double) ((1-q00) * (1-q33))));
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 1:
				q00=Math.pow((1-p), 7);
				q01=(7*p) * (Math.pow((1-p), 6));
				q02=(21* (Math.pow(p, 2))) * (Math.pow((1-p), 5));
				q03=(35* (Math.pow(p, 3))) * (Math.pow((1-p), 4));
				q11=Math.pow((1-p), 6);
				q12=(6*p) * (Math.pow((1-p), 5));
				q13=(15* (Math.pow(p, 2))) * (Math.pow((1-p), 4));
				q22=Math.pow((1-p), 5);
				q23=(5*p) * (Math.pow((1-p), 4));
				q33=Math.pow((1-p), 4);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11)))
						+ (((double) q01*q12)/((double) ((1-q00) * (1-q11) * (1-q22))))
						+ (((double) q01*q12*q13)/((double) ((1-q00) * (1-q11) * (1-q22) * (1-q33))))
						+ (((double) q02)/((double) (1-q00) * (1-q22))) + (((double) q02*q23)/((double) ((1-q00) * (1-q22) * (1-q33))))
						+ (((double) q03)/((double) ((1-q00) * (1-q33))));
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 2:
				q00=Math.pow((1-p), 6);
				q01=(6*p) * (Math.pow((1-p), 5));
				q02=(15* (Math.pow(p, 2))) * (Math.pow((1-p), 4));
				q03=(4* (Math.pow(p, 3))) * (Math.pow((1-p), 3));
				q11=Math.pow((1-p), 5);
				q12=(5*p) * (Math.pow((1-p), 4));
				q13=(10* (Math.pow(p, 2))) * (Math.pow((1-p), 3));
				q22=Math.pow((1-p), 4);
				q23=(4*p) * (Math.pow((1-p), 3));
				q33=Math.pow((1-p), 3);
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11)))
						+ (((double) q01*q12)/((double) ((1-q00) * (1-q11) * (1-q22))))
						+ (((double) q01*q12*q13)/((double) ((1-q00) * (1-q11) * (1-q22) * (1-q33))))
						+ (((double) q02)/((double) (1-q00) * (1-q22))) + (((double) q02*q23)/((double) ((1-q00) * (1-q22) * (1-q33))))
						+ (((double) q03)/((double) ((1-q00) * (1-q33))));
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 3:
				q00=Math.pow((1-p), 5);
				q01=(5*p) * (Math.pow((1-p), 4));
				q02=(10* (Math.pow(p, 2))) * (Math.pow((1-p), 3));
				q03=(10* (Math.pow(p, 3))) * (Math.pow((1-p), 2));
				q11=Math.pow((1-p), 4);
				q12=(4*p) * (Math.pow((1-p), 3));
				q13=(6* (Math.pow(p, 2))) * (Math.pow((1-p), 2));
				q22=Math.pow((1-p), 3);
				q23=(3*p) * (Math.pow((1-p), 2));
				q33=Math.pow((1-p), 2);
				W = (((double) q00)/((double) (1-q00)) + ((double) q01)/((double) (1-q00) * (1-q11)))
						+ (((double) q01*q12)/((double) ((1-q00) * (1-q11) * (1-q22))))
						+ (((double) q01*q12*q13)/((double) ((1-q00) * (1-q11) * (1-q22) * (1-q33))))
						+ (((double) q02)/((double) (1-q00) * (1-q22))) + (((double) q02*q23)/((double) ((1-q00) * (1-q22) * (1-q33))))
						+ (((double) q03)/((double) ((1-q00) * (1-q33))));
				W= Double.parseDouble(roundValue.format(W));
				break;
			case 4:
				q00=Math.pow((1-p), 4);
				q01=(4*p) * (Math.pow((1-p), 3));
				q02=(6* (Math.pow(p, 2))) * (Math.pow((1-p), 2));
				q03=(4* (Math.pow(p, 3))) * (1-p);
				q11=Math.pow((1-p), 3);
				q12=(3*p) * (Math.pow((1-p), 2));
				q13=(3* (Math.pow(p, 2))) * (1-p);
				q22=Math.pow((1-p), 2);
				q23=(2*p) * (1-p);
				q33=1-p;
				W = (((double) q00)/(double) (1-q00)) + (((double) q01)/((double) (1-q00) * (1-q11)))
						+ (((double) q01*q12)/((double) ((1-q00) * (1-q11) * (1-q22))))
						+ (((double) q01*q12*q13)/((double) ((1-q00) * (1-q11) * (1-q22) * (1-q33))))
						+ (((double) q02)/((double) (1-q00) * (1-q22))) + (((double) q02*q23)/((double) ((1-q00) * (1-q22) * (1-q33))))
						+ (((double) q03)/((double) ((1-q00) * (1-q33))));
				W= Double.parseDouble(roundValue.format(W));
				break;
			}
		}
		break;
		}
		return W;
	}



}