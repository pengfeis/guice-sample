package pengfei.learn.jedis;

import com.google.common.base.Stopwatch;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class FlashPipeLineInRedis {

    public static AtomicInteger i = new AtomicInteger(1);
    private static final int justI = 4;

    private static boolean isWhiteDomain(String domain, List<String> whites) {
        for (String rootDomain : whites) {
            if (Pattern.matches("^\\S+\\." + rootDomain.replace(".", "\\."), domain)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost", 16449);
        Stopwatch sw = Stopwatch.createStarted();
        for (int j = 0; j < 100; j++) {
            long randomInt = new Random().nextInt(1000);
            jedis.hset("just-4-performance-test", "foo-" + randomInt, "bar-" + randomInt);

        }
        sw.stop();
        System.out.println("serialization running " + sw.elapsed(TimeUnit.MILLISECONDS));

        sw.reset();

        System.out.println("================================================================");

        sw.start();
        Pipeline pipeline = jedis.pipelined();
        for (int j = 0; j < 100; j++) {
            long randomInt = new Random().nextInt(1000);
            pipeline.hset("just-4-performance-test", "pip-" + randomInt, "pong-" + randomInt);
        }
        pipeline.syncAndReturnAll();
        sw.stop();
        System.out.println("pipeline running " + sw.elapsed(TimeUnit.MILLISECONDS));
    }

//    public static void main(String[] args) {
//        ArrayList<String> lists = Lists.newArrayList("jd.com", "samsclub.com");
//
//        System.out.println(isWhiteDomain("im.jd.com", lists)); // true
//        System.out.println(isWhiteDomain("im.jdx.com", lists));// false
//        System.out.println(isWhiteDomain("im-a.jd.com", lists));// true
//        System.out.println(isWhiteDomain("im.ajd.com", lists)); //false
//        System.out.println(isWhiteDomain("im.jdacom", lists)); //false
//        System.out.println(isWhiteDomain("im.jd.com.cn", lists)); //false
//
//        System.out.println("jd.com.cn".replaceAll("\\.", "\\\\."));
//        System.out.println("samsclub.com".replaceAll("\\.", "\\\\."));
//    }

//    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//
////        App2 app = new App2();
//
//
//
//
////
////
////        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
////        theUnsafe.setAccessible(true);
////
////        Unsafe unsafe = (Unsafe) theUnsafe.get(null);
////
////        boolean b = unsafe.compareAndSwapInt(app, unsafe.objectFieldOffset(App2.class.getDeclaredField("justI")), 4, 2);
////        System.out.println(b);
////        System.out.println(app.justI);
//        final Object obj = new Object();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("2 t");
//                LockSupport.unpark(Thread.currentThread());
//            }
//        }).start();
//
//        System.out.println("begin...");
//        LockSupport.park(obj);
//        Thread.currentThread().isInterrupted();
//        System.out.println("end...");
//
//
//    }

}
