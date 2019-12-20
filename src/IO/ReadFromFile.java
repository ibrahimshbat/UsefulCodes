package IO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class ReadFromFile {

	public static void main(String[] args) throws IOException {
		String fullPath = System.getProperty("user.home")+"path";

		BufferedReader reader = new BufferedReader(new FileReader(fullPath));		
		
		String aff = reader.readLine();
		while (aff != null) {
			//parts = aff.split(" ");
			//affiliate = new Affiliate((long) Long.parseLong(parts[0]), parts[1], Double.parseDouble(parts[2]), Double.parseDouble(parts[3]));
		//	affiliates.put(Long.parseLong(parts[0]), affiliate);
			// read next line
			//aff = reader.readLine();
		}
		//reader.close();

	}

}
