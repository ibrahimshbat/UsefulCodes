package timeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;


public class LongToTime {

	    public static void main(String[] args) {
	        long val = System.currentTimeMillis();
	        Date date=new Date(val);
	        SimpleDateFormat df2 = new SimpleDateFormat("HH:mm:ss.SSSZ");
	        String dateText = df2.format(date);
	        System.out.println(dateText);
	    }
	}

	

