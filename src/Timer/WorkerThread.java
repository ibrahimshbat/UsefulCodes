package Timer;

 
import java.util.Date;
 
public class WorkerThread implements Runnable{
 
private String command;
     
    public WorkerThread(String s){
        this.command=s;
    }
 
    @Override
    public void run() {
    	System.out.println(command);
    	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // System.out.println(Thread.currentThread().getName()+" Start. Time = "+new Date());
       // processCommand();
       // System.out.println(Thread.currentThread().getName()+" End. Time = "+new Date());
    }
 
    private void processCommand() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
 
    @Override
    public String toString(){
        return this.command;
    }
}