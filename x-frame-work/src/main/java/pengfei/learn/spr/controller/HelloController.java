package pengfei.learn.spr.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.common.base.Stopwatch;
import com.google.common.collect.ImmutableMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pengfei.learn.spr.service.SaySomethingService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author supengfei
 */
@Controller
@RequestMapping("/hello")
public class HelloController {

    final Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicInteger atomicNumber = new AtomicInteger(0);

    private volatile int count = 0;


    @Resource
    private SaySomethingService saySomethingService;

    public HelloController() {
        System.out.println("---------controller--------");
    }


    @RequestMapping(value = "/first")
    public String printHello(ModelMap model) throws InterruptedException {


        ExecutorService executorService = Executors.newFixedThreadPool(10, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "test-pool-" + atomicNumber.getAndAdd(1));
            }
        });

        for (int i = 0; i < 100; i++) {
            Future<?> future = executorService.submit(() -> {
                atomicNumber.getAndAdd(1);
                logger.info("Current int is " + atomicNumber.get());
            });

        }


        Stopwatch stopWatch = Stopwatch.createStarted();
        executorService.shutdownNow();

        stopWatch.stop();
        logger.info("after shutting down " + stopWatch.elapsed(TimeUnit.SECONDS));

        model.addAttribute("message", "Hello Spring MVC Framework!" + atomicNumber.get() + "spend time " + stopWatch.elapsed(TimeUnit.SECONDS));
        return "hello";
    }

    @RequestMapping(value = "/second")
    public @ResponseBody
    String printCurrentCount(Integer currentVal, HttpServletRequest request) {
        return ImmutableMap.of("int", count++, "atomicInt", atomicNumber.incrementAndGet()).toString();
    }


    @RequestMapping(value = "/third/{orderCode}")
    public String getSomeJsonData(@PathVariable String orderCode) {
        return JSONObject.toJSONString(ImmutableMap.of("code", "200", "msg", "你好", "data", orderCode));
    }
}