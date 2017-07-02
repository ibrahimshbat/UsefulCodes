package Log;
import org.apache.log4j.Logger;

public class LogLevelTest {

   private static org.apache.log4j.Logger log = Logger.getLogger(LogLevelTest.class);
   
   public static void main(String[] args) {
   
      log.trace("Trace Message!");
      log.debug("Debug Message!");
      log.info("Info Message!");
      log.warn("Warn Message!");
      log.error("Error Message!");
      log.fatal("Fatal Message!");
   }
}