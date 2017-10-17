package pengfei.learn.guava.limit;

import com.google.common.util.concurrent.RateLimiter;

public class RatLimitSample {
    public static void main(String[] args) {
        RateLimiter limiter = RateLimiter.create(5);

        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));

        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
        System.out.println(limiter.acquire(1));
    }
}
