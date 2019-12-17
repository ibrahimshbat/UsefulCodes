package IO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

import thinkific.user.User;

public class WriteToFile {

	public static void main(String[] args) {
		PrintWriter referralsData = null;
		try {
			// System.out.println("Who is this:"+users.get(0));
			referralsData = new PrintWriter(new BufferedWriter(
					new FileWriter(System.getProperty("user.home") + "/Downloads/emailsThinkific.csv", false)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			referralsData.println("Write somethings to the file");

	
		referralsData.close();	

	}

}
