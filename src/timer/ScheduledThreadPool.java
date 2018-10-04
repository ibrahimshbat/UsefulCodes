package timer;

 
import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
 
 
public class ScheduledThreadPool {
 
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);
         
         
        //schedule to run after sometime
        System.out.println("Current Time = "+new Date());
        //for(int i=0; i<2; i++){
          //  Thread.sleep(1000);
            WorkerThread worker = new WorkerThread("1");
            ScheduledFuture  a1 = scheduledThreadPool.schedule(worker, 2, TimeUnit.SECONDS);
           //a1.cancel(true);
//            
            	
            WorkerThread worker1 = new WorkerThread("2");
            ScheduledFuture  a2 = scheduledThreadPool.schedule(worker1, 2, TimeUnit.SECONDS);
          
           // a2.cancel(true);
//             
           // scheduledThreadPool.scheduleAtFixedRate(worker, 5, 2, TimeUnit.SECONDS);
      //  }
         
        //add some delay to let some threads spawn by scheduler
        //Thread.sleep(30000);
         
       // scheduledThreadPool.shutdown();
      // while(!scheduledThreadPool.isTerminated()){
         //  wait for all tasks to finish
       // }
        //System.out.println("Finished all threads");
    }
}