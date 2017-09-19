package pengfei.learn.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class Subs {


    public void subscriber(String ch) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0l, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new ThreadFactory() {
            private AtomicInteger threadCount = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread("test" + threadCount.incrementAndGet());
            }
        }, new ThreadPoolExecutor.DiscardPolicy());

        Optional<String> channel = Optional.ofNullable(ch);

        boolean rolling = true;
        while (rolling) {
            try {
                rolling = false;
                jedis.subscribe(pubSub, channel.orElse("1"));
            } catch (Exception e) {
                rolling = true;
            }
        }
    }


    static long sum = 0l;

    final static JedisPubSub pubSub = new JedisPubSub() {

        @Override
        public void onMessage(String channel, String message) {

            int i = message.indexOf(":");


            String sendingTime = message.substring(0, i);

            Long gap = System.currentTimeMillis() - Long.parseLong(sendingTime);
            sum += gap;

            System.out.println("rec msg: " + " @ " + sum);
        }
    };

    public static void main(String[] args) {
        new Subs().subscriber(null);
        System.out.println("end");
    }

}
