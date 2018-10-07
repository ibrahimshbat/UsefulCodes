package timer;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Calendar;
import java.util.TimeZone;
 
 /*
  * This class uses to test and see how timer class works
  */
public class MyTimer 
{
    Timer timer;
    Calendar startTime;
 
    public MyTimer(int seconds) 
    {
        startTime = Calendar.getInstance(TimeZone.getDefault());
        startTime.set(Calendar.HOUR_OF_DAY, 20);
        startTime.set(Calendar.MINUTE, 56);
        startTime.set(Calendar.SECOND, 00);
        timer = new Timer();
        timer.schedule(new RunTask(), 5000, 5000);
    }
 
    class RunTask extends TimerTask 
    {
        public void run() 
        {
            System.out.println("It's Time");
            timer.cancel(); //Terminate the timer thread
            timer = new Timer();
            timer.schedule(new RunTask(), 5000, 5000);
        }
    }
 
    public static void main(String args[]) 
    {
        new MyTimer(5);
        System.out.println("Waiting");
    }
}