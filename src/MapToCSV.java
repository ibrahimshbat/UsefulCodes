import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;


public class MapToCSV {
	private static PrintWriter outFileToWork;

	public static void main(String[] args) throws IOException {
		outFileToWork = new PrintWriter(new BufferedWriter(new FileWriter("H://Zab.csv", true)));
		Map<Long,Double> lats = new HashMap<Long,Double>();
		lats.put((long)1, 10.0);
		lats.put((long)2, 100.0);
		lats.put((long)3, 1000.0);
		lats.put((long)5, 160.0);
		lats.put((long)6, 10.0);
		lats.put((long)7, 11.0);
//		for (int i=0;i<=lats.size();i++){
//			outFileToWork.println(lats.);
//		}
		for (Map.Entry<Long, Double> entry : lats.entrySet()) {
			outFileToWork.println(entry.getKey()+ "," + entry.getValue());
			 System.out.println("key=" + entry.getKey() + ", value=" + entry.getValue());

		}
		outFileToWork.close();
		
		
	}
}
