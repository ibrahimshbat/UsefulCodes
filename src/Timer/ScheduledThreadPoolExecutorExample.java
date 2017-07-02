package Timer;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
* @author Chandan Singh
*
*/
public class ScheduledThreadPoolExecutorExample
{
   public static void main(String[] args) throws InterruptedException, ExecutionException
	{

		Runnable runnabledelayedTask = new Runnable()
		{
			@Override
			public void run()
			{
			     System.out.println(Thread.currentThread().getName()+" is Running Delayed Task");
			}
		};


		Callable callabledelayedTask = new Callable()
		{

			@Override
			public String call() throws Exception
			{
			      return "GoodBye! See you at another invocation...";
			}
		};
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(2);
		//ScheduledExecutorService scheduledPool = Executors.newScheduledThreadPool(4);
		 executor.schedule(runnabledelayedTask, 1, TimeUnit.SECONDS);
		    //System.out.println("getTaskCount-->>"+executor.getTaskCount());

		Thread.sleep(3000);
	    System.out.println("the maximum allowed number of threads-->>"+executor.getActiveCount());

		executor.remove(runnabledelayedTask);
		//System.out.println("s1f completed-->>"+sf1.isDone());
		ScheduledFuture sf2 = executor.schedule(callabledelayedTask, 10, TimeUnit.SECONDS);
		//Thread.sleep(3000);
	    System.out.println("getTaskCount-->>"+(executor.getCompletedTaskCount()));

		//System.out.println("ScheduledFuture2 get() ="+sf2.get());

		//System.out.println("ScheduledFuture1 get() ="+sf1.get());
		//System.out.println("ScheduledFuture2 get() ="+sf2.get());
		
		System.out.println("Before shutdown");

		executor.shutdown();
        System.out.println("Near end");
		System.out.println("Is ScheduledThreadPool shutting down? "+executor.isShutdown());

	}
}
