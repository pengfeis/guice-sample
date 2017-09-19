package pengfei.learn.jedis;

import com.google.common.collect.Lists;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

import java.nio.charset.Charset;
import java.time.Instant;
import java.util.Collection;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class RedisPubSubDelay {

    private Jedis jedis = new Jedis("127.0.0.1", 6379);

    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(1, 1, 0l, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10), new ThreadFactory() {
        private AtomicInteger threadCount = new AtomicInteger(0);

        @Override
        public Thread newThread(Runnable r) {
            return new Thread("test" + threadCount.incrementAndGet());
        }
    }, new ThreadPoolExecutor.DiscardPolicy());


    final JedisPubSub pubSub = new JedisPubSub() {

        @Override
        public void onMessage(String channel, String message) {
            System.out.println("rec msg: " + message + " @ " + System.currentTimeMillis());
            super.onMessage(channel, message);
        }
    };


    private Runnable task = () -> {
        jedis.subscribe(pubSub, "1");
        System.out.println("ending....");
    };


    public static void main(String[] args) throws InterruptedException {
        final RedisPubSubDelay pubSub = new RedisPubSubDelay();


        String now = Instant.now().toString();

        StringBuilder sb = new StringBuilder(now);


        for (int j = 0; j < 100; j++) {
            sb.append(System.lineSeparator());
            sb.append(now);

        }


        for (int i = 0; i < 100; i++) {
            pubSub.jedis.publish("1".getBytes(Charset.forName("UTF-8")), (System.currentTimeMillis() + ": " + sb.toString()).getBytes(Charset.forName("UTF-8")));
        }


        Optional<Collection<String>> o = Optional.ofNullable(Lists.newArrayList("1", null, "2"));

        Optional<Collection<String>> tmp = o.filter(strings -> null != strings);

        System.out.println(tmp.orElse(Lists.newArrayList()));


        Integer t = 0, p, q;


        Integer i = t = 3;
        System.out.println(i);
        System.out.println(t);


//        (p = q).intValue();


    }
}
