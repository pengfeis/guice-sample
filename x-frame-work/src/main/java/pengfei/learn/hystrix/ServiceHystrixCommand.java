package pengfei.learn.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixThreadPoolKey;
import org.apache.commons.lang.math.RandomUtils;

import java.util.Random;

/**
 * @author pengfeisu
 */
public class ServiceHystrixCommand extends HystrixCommand<String> {
    private final String name;

    public ServiceHystrixCommand(String name) {
        super( Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("ExampleGroup"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("PrimaryCommand"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(1000)));
        this.name = name;
    }

    @Override
    protected String run() {
        // a real example would do work like a network call here
        for (; ; ) {
            if (RandomUtils.nextInt() < 1) {
                return "go";
            }
        }
    }


    @Override
    protected String getFallback() {
        return "Hello Failure" + name + "!";
    }

    public static void main(String[] args) {
        String world = new ServiceHystrixCommand("World").execute();
        System.out.println(world);
    }

}
