package statistic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.math3.distribution.TDistribution;

/*
 * This class provides stats tools
 */
public class Statistic {

	//For 20 Experewmeint, For example in 10% we have 20 samples, each has 10000 latencies.
	private static final double nCI10 =  2.093;
	private static final double nCI20 =  2.023;
	private static final double nCI30 =  2.001;
	private static final double nCI40 =  1.990;
	private static final double nCI50 =  1.984;
	private static final double nCI60 =  1.980;
	private static final double nCI70 =  1.977;
	private static final double nCI80 =  1.975;
	private static final double nCI90 =  1.973;
	private static final double nCI100 = 1.972;

	//For 10 Experewmeint, For example in 10% we have 10 samples, each has 10000 latencies.
	private static final double nCI10_1 =  2.262;
	private static final double nCI20_1 =  2.093;
	private static final double nCI30_1 =  2.045;
	private static final double nCI40_1 =  2.023;
	private static final double nCI50_1 =  2.010;
	private static final double nCI60_1 =  2.001;
	private static final double nCI70_1 =  1.995;
	private static final double nCI80_1 =  1.990;
	private static final double nCI90_1 =  1.987;
	private static final double nCI100_1 = 1.984;


	public static Map<Integer, List<Double>> convertToNumber(Map<Integer, List<String>> data) {
		Map<Integer, List<Double>> toNumbers = new HashMap<Integer, List<Double>>();
		List<String> stringL = new ArrayList<String>();
		List<Double> doubleL = new ArrayList<Double>();
		for (int i = 10; i <=100; i+=10) {
			stringL = data.get(i);
			for(String s: stringL){
				String [] ss = s.split("-");
				doubleL.add(Double.parseDouble(ss[0]));
				doubleL.add(Double.parseDouble(ss[1]));
			}
			toNumbers.put(i, doubleL);
			doubleL = new ArrayList<Double>();
		}

		return toNumbers;
	}

	public static List<Double> find10Averages(int ratio, List<Double> data) {
		int nSamples = 20;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double avg=0.0;
		List<Double> averages = new ArrayList<Double>();
		for (int i = 0; i <20; i++) {
			avg = mean(data.subList(index, (index+sampleSize)));
			averages.add(avg);
			index+=sampleSize;
		}		
		return averages;
	}

	public static List<Double> find90th(int ratio, List<Double> data) {
		int nSamples = 20;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double p90=0.0;
		List<Double> p90s = new ArrayList<Double>();
		for (int i = 0; i <20; i++) {
			p90 = percentile90th(data.subList(index, (index+sampleSize)));
			p90s.add(p90);
			index+=sampleSize;
		}		
		return p90s;
	}
	public static List<Double> find95th(int ratio, List<Double> data) {
		int nSamples = 20;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double p95=0.0;
		List<Double> p95s = new ArrayList<Double>();
		for (int i = 0; i <20; i++) {
			p95 = percentile95th(data.subList(index, (index+sampleSize)));
			p95s.add(p95);
			index+=sampleSize;
		}		
		return p95s;
	}
	public static List<Double> find99th(int ratio, List<Double> data) {
		int nSamples = 20;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double p99=0.0;
		List<Double> p99s = new ArrayList<Double>();
		for (int i = 0; i <20; i++) {
			p99 = percentile99th(data.subList(index, (index+sampleSize)));
			p99s.add(p99);
			index+=sampleSize;
		}		
		return p99s;
	}

	public static List<Double> find10AveragesN(int ratio, List<Double> data) {
		//int nSamples = ratio * 2;
		int nSamples = ratio;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double avg=0.0;
		List<Double> averages = new ArrayList<Double>();
		for (int i = 0; i <nSamples; i++) {
			avg = mean(data.subList(index, (index+sampleSize)));
			averages.add(avg);
			index+=sampleSize;
		}		
		return averages;
	}


	public static List<Double> find90thN(int ratio, List<Double> data) {
		//int nSamples = ratio * 2;
		int nSamples = ratio;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double p90=0.0;
		List<Double> p90s = new ArrayList<Double>();
		for (int i = 0; i <nSamples; i++) {
			p90 = percentile90th(data.subList(index, (index+sampleSize)));
			p90s.add(p90);
			index+=sampleSize;
		}		
		return p90s;
	}
	public static List<Double> find95thN(int ratio, List<Double> data) {
		//int nSamples = ratio * 2;
		int nSamples = ratio;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double p95=0.0;
		List<Double> p95s = new ArrayList<Double>();
		for (int i = 0; i <nSamples; i++) {
			p95 = percentile95th(data.subList(index, (index+sampleSize)));
			p95s.add(p95);
			index+=sampleSize;
		}		
		return p95s;
	}
	public static List<Double> find99thN(int ratio, List<Double> data) {
		//int nSamples = ratio * 2;
		int nSamples = ratio;
		int sampleSize = (data.size()/nSamples);
		int index =0;
		double p99=0.0;
		List<Double> p99s = new ArrayList<Double>();
		for (int i = 0; i <nSamples; i++) {
			p99 = percentile99th(data.subList(index, (index+sampleSize)));
			p99s.add(p99);
			index+=sampleSize;
		}		
		return p99s;
	}

	public static double mean(List<Double> data) {
		double sum=0;
		double avg = 0;
		for (Double lat : data) {
			sum += lat;
		}
		avg = (double) sum / data.size();
		return avg;

	}
	public static double meanAllMap(Map<Integer, List<Double>> data) {
		double sum=0;
		double avg = 0;
		int countt=0;
		for(int i=10;i<=100;i+=10){
			List<Double> latt=data.get(i);
			for (Double lat : latt) {
				sum += lat;
				countt++;
			}
		}
		avg = (double) sum / countt;
		return avg;

	}
	public static Map<Integer, Double> mean(Map<Integer,List<Double>> dataMap) {
		double sum=0;
		double avg = 0;
		Map<Integer, Double> result = new TreeMap<Integer, Double>();
		for (int i=10;i<=100; i+=10) {
			avg =  mean(dataMap.get(i));
			result.put(i, avg);
		}
		return result;

	}

	public static double stdev(List<Double> lat, double mean){
		List<Double> distFromMean = new ArrayList<Double>();
		double sumDistFromMean = 0.0, stdev=0.0;
		for(int i = 0; i < lat.size(); i++){
			distFromMean.add(Math.pow((lat.get(i)-mean),2));
		}

		for(int i = 0; i < distFromMean.size(); i++){
			sumDistFromMean += distFromMean.get(i);
		}

		stdev = Math.sqrt((sumDistFromMean/(lat.size()-1)));

		return stdev;
	}

	public static String computeCI(List<Double> lats){
		double marginError =0.0, ci95 = 1.96, CILower=0.0, CIUpper=0.0;
		double mean = mean(lats);
		double stdev = stdev(lats, mean);
		marginError = ci95 * (stdev/(Math.sqrt((lats.size()))));
		CILower = mean - marginError;
		CIUpper = mean + marginError;
		return ""+CILower+","+CIUpper;

	}

	public static double findCIN(int ratio){
		double t=0.0;
		switch(ratio){
		case 10:
			t=nCI10_1;
			break;
		case 20:
			t=nCI20_1;
			break;
		case 30:
			t=nCI30_1;
			break;
		case 40:
			t=nCI40_1;
			break;
		case 50:
			t=nCI50_1;
			break;
		case 60:
			t=nCI60_1;
			break;
		case 70:
			t=nCI70_1;
			break;
		case 80:
			t=nCI80_1;
			break;
		case 90:
			t=nCI90_1;
			break;
		case 100:
			t=nCI100_1;
			break;
		}
		return t;

	}

	public static String computeCIV2(int ratio,List<Double> lats){
		double marginError =0.0, ci95 = 0.0, CILower=0.0, CIUpper=0.0;
		ci95 = findCIN(ratio);
		double value = mean(lats);
		double stdev = stdev(lats, value);
		marginError = ci95 * (stdev/(Math.sqrt(lats.size())));
		CILower = value - marginError;
		CIUpper = value + marginError;
		return ""+value+","+CILower+","+CIUpper;

	}

	public static double percentile50th(List<Long> latInLong){
		List<Long> latenciesInLong = new ArrayList<Long>(latInLong);
		List<Double> latenciesInDouble = new ArrayList<Double>();
		for (int i = 0; i < latInLong.size(); i++) {
			latenciesInDouble.add((double) (((double) latenciesInLong.get(i))/1000000));
		}
		Collections.sort(latenciesInDouble);
		return latenciesInDouble.get((int)(latenciesInDouble.size()*0.50)-1);

	}

	public static double percentile90th(List<Double> latenciesInDouble){
		//System.out.println("Before="+latenciesInDouble);
		Collections.sort(latenciesInDouble);
		return latenciesInDouble.get((int)(latenciesInDouble.size()*0.90)-1);

	}
	public static double percentile95th(List<Double> latenciesInDouble){
		//for (int i = 0; i < latenciesInLong.size(); i++) {
		//latenciesInDouble.add((double) (((double) latenciesInLong.get(i))/1000000));
		//}
		Collections.sort(latenciesInDouble);
		return latenciesInDouble.get((int)(latenciesInDouble.size()*0.95)-1);

	}

	public static double percentile99th(List<Double> latenciesInDouble){
		Collections.sort(latenciesInDouble);
		for (int i = 0; i < latenciesInDouble.size(); i++) {
			//System.out.println(latenciesInDouble.get(i));
		}
		return latenciesInDouble.get((int)(latenciesInDouble.size()*0.99)-1);

	}
	
	public static double find_TDistribution(int degree){
		double value = 0.0;
		TDistribution t = new TDistribution(degree);
		value = t.inverseCumulativeProbability(1-0.05/2);
		System.out.println(value);
		
		return value;
	}
}
