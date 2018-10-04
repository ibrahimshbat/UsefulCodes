package timer;

import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutor {
	public static void main(String[] args) {
	    ScheduledThreadPoolExecutor executor 
	        = new ScheduledThreadPoolExecutor(1);

	    Runnable task = new Runnable() {
	        @Override
	        public void run() {
	            System.out.println("Hello World!");
	        }
	    };

	    ScheduledFuture future 
	        = executor.schedule(task, 
	            1, TimeUnit.MILLISECONDS);

	    future.cancel(true);
	}
}
