package pengfei.learn.spr.controller;

import com.google.common.base.Stopwatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/hello")
public class HelloController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicInteger atomicNumber = new AtomicInteger(0);


    @RequestMapping(value = "/first")
    public String printHello(ModelMap model) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            public Thread newThread(Runnable r) {
                return new Thread(r, "test-pool-" + atomicNumber.getAndAdd(1));
            }
        });

        for (int i = 0; i < 100; i++) {
            Future<?> future = executorService.submit(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(100);
                        atomicNumber.getAndAdd(1);
                    } catch (InterruptedException e) {
                    }

                    logger.info("Current int is " + atomicNumber.get());
                }
            });

        }

        Stopwatch stopWatch = Stopwatch.createStarted();
        executorService.awaitTermination(10l, TimeUnit.SECONDS);

        stopWatch.stop();
        logger.info("after shutting down " + stopWatch.elapsed(TimeUnit.SECONDS));

        model.addAttribute("message", "Hello Spring MVC Framework!" + atomicNumber.get() + "spend time " + stopWatch.elapsed(TimeUnit.SECONDS));
        return "hello";
    }
}