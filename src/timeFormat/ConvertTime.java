package timeFormat;

import java.util.concurrent.TimeUnit;

public class ConvertTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long now = System.currentTimeMillis();
		long startTime =TimeUnit.MILLISECONDS.toSeconds(now);;//sec
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		now = System.currentTimeMillis();
		//startTime =TimeUnit.MILLISECONDS.toSeconds(now);;//sec
		long result = TimeUnit.MILLISECONDS.toSeconds(now)-startTime;
		startTime =TimeUnit.MILLISECONDS.toSeconds(now);;//sec
		System.out.println("result="+result);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//now = System.currentTimeMillis();
		result = ((TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()))-startTime);
		System.out.println("result="+result);
	}

}
