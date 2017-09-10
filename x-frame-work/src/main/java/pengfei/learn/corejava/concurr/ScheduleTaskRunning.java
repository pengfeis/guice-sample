package pengfei.learn.corejava.concurr;

import java.time.Instant;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduleTaskRunning {

    private ScheduleTaskRunning() {
        Executors.newSingleThreadScheduledExecutor(r -> new Thread(r, "Su-Scheduled-Thread-0")).scheduleAtFixedRate(() -> {
            System.out.println("now: " + Instant.now().toString());

            try {
                Thread.sleep(7000);
                System.out.println(Thread.currentThread().getName() + " after sleep");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }, 0, 5, TimeUnit.SECONDS);
    }


    public static ScheduleTaskRunning getInstance() {
        return RunnerHolder.INSTANCE;
    }


    private static class RunnerHolder {
        static final ScheduleTaskRunning INSTANCE = new ScheduleTaskRunning();
    }


    public static void main(String[] args) {
        getInstance();
    }
}
