package TestSortedMap;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class TestSortedMap {
	public static void main(String[] args) throws IOException {
		//Map<Double, Double> map = new HashMap<Double, Double>();        
		TreeMap<Double, Double> treeMap = new TreeMap<Double, Double>();
		treeMap.put(10000.56, 0.65);
		treeMap.put(555.56, 2.65);
		treeMap.put(52.56, 0.95);
	    System.out.println(treeMap);
		SortedSet<Double> ps = new TreeSet<Double>();
		ps.add(1.5);
		ps.add(1.5);
		ps.add(1.56);
		ps.add(1.56);
		ps.add(1.56);
		ps.add(1.56);
		ps.add(1.56);
	    System.out.println(ps);
	    Iterator<Double> it = ps.iterator();
	    System.out.println(it.next());
	    System.out.println(it.next());
	    double n=0.123456;
	    DecimalFormat roundValue = new DecimalFormat("#.00000");
	    System.out.println(Double.parseDouble(roundValue.format(n)));
	    final Entry<Double, Double> lastEntry = treeMap.lastEntry();
	    System.out.println("Last Key="+lastEntry.getKey());
		TreeMap<Double, Double> copypW = new TreeMap<Double, Double>(treeMap);
		 System.out.println("treeMap size="+treeMap.size());
		 System.out.println("Before treeMap="+treeMap);
		 treeMap.remove(555.56);
		 System.out.println("After remove, treeMap size="+treeMap.size());
		 System.out.println("treeMap="+treeMap);
		 System.out.println("copypW="+copypW);
		 copypW.remove(52.56);
		 System.out.println("copypW="+copypW);
		 System.out.println("treeMap="+treeMap);









		
	}
}
