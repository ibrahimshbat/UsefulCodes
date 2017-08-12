package TestString;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintStrings {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter outFile = new PrintWriter(new BufferedWriter(new FileWriter("D:/Test.CSV",true)));

		System.out.println("sdad \njgjsdgjasdgjag");
		outFile.print("A,B,c,d \n");
		outFile.print("V,K,c,d \n");
		outFile.print("G,M,c,d \n");
		outFile.flush();


		

	}

}
