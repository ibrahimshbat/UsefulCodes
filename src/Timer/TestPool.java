package Timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/**
 Run a simple task once every second, starting 3 seconds from now.
 Cancel the task after 20 seconds.
*/
public final class TestPool {
  
  /** Run the example. */
  public static void main(String... aArgs) throws InterruptedException {
	long zxid=0;

    log("Main started.");
    TestPool alarmClock = new TestPool(3, 1000, 20);
    alarmClock.activateAlarmThenStop();
    /*
    To start the alarm at a specific date in the future, the initial delay
    needs to be calculated relative to the current time, as in : 
    Date futureDate = ...
    long startTime = futureDate.getTime() - System.currentTimeMillis();
    AlarmClock alarm = new AlarmClock(startTime, 1, 20);
    This works only if the system clock isn't reset.
    */
    log("Main ended.");
  }
  
  TestPool(long aInitialDelay, long aDelayBetweenBeeps, long aStopAfter){
    fInitialDelay = aInitialDelay;
    fDelayBetweenRuns = aDelayBetweenBeeps;
    fShutdownAfter = aStopAfter;
    fScheduler = Executors.newScheduledThreadPool(1000000);    
  }
  
  /** Sound the alarm for a few seconds, then stop. */
	void activateAlarmThenStop() {
		SoundAlarmTask soundAlarmTask;
		for (int i = 0; i < 1000; i++) {
			log("i="+i);
			soundAlarmTask = new SoundAlarmTask();
			ScheduledFuture<?> soundAlarmFuture = fScheduler.schedule(soundAlarmTask, fDelayBetweenRuns,
					TimeUnit.MILLISECONDS);
			soundAlarmTask.setfSchedFuture(soundAlarmFuture);
			soundAlarmTask.setZxid(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

  // PRIVATE 
  private final ScheduledExecutorService fScheduler;
  private final long fInitialDelay;
  private final long fDelayBetweenRuns;
  private final long fShutdownAfter;
  
  private static void log(String aMsg){
    System.out.println(aMsg);
  }

  /** If invocations might overlap, you can specify more than a single thread.*/ 
  private static final int NUM_THREADS = 1;
  private static final boolean DONT_INTERRUPT_IF_RUNNING = false;
  
   class SoundAlarmTask implements Runnable {
	    private ScheduledFuture<?> fSchedFuture; 
	    private long zxid;

    public ScheduledFuture<?> getfSchedFuture() {
			return fSchedFuture;
		}
		public void setfSchedFuture(ScheduledFuture<?> fSchedFuture) {
			this.fSchedFuture = fSchedFuture;
		}
		
	public long getZxid() {
			return zxid;
		}
		public void setZxid(long zxid) {
			this.zxid = zxid;
		}
	@Override public void run() {
      ++fCount;
      log("Expired For " + zxid);
      fSchedFuture.cancel(DONT_INTERRUPT_IF_RUNNING);
      /* 
       Note that this Task also performs cleanup, by asking the 
       scheduler to shutdown gracefully. 
      */
      fScheduler.shutdown();

    }
    private int fCount;
  }
  
  private final class StopAlarmTask implements Runnable {
    StopAlarmTask(ScheduledFuture<?> aSchedFuture){
      fSchedFuture = aSchedFuture;
    }
    @Override public void run() {
      log("Stopping alarm.");
      fSchedFuture.cancel(DONT_INTERRUPT_IF_RUNNING);
      /* 
       Note that this Task also performs cleanup, by asking the 
       scheduler to shutdown gracefully. 
      */
      fScheduler.shutdown();
    }
    private ScheduledFuture<?> fSchedFuture;
  }
} 