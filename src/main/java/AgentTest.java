import java.lang.instrument.Instrumentation;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author vicky
 */
public class AgentTest {

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("this is an perform monitor agent.");

        Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                Metric.printMemoryInfo();
                Metric.printGCInfo();
            }
        }, 0, 5000, TimeUnit.MILLISECONDS);
    }
}
