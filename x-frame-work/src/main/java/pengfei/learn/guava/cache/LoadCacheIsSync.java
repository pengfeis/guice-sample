package pengfei.learn.guava.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class LoadCacheIsSync {

    public static void main(String[] args) throws ExecutionException {

        LoadingCache<String, String> cache = CacheBuilder
            .newBuilder()
            .refreshAfterWrite(2, TimeUnit.SECONDS)
            .build(new CacheLoader<String, String>() {
                @Override
                public String load(String s) throws Exception {
                    System.out.println("Thread.currentThread() = " + Thread.currentThread());
                    return "world";
                }
            });
        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + cache.get("hello"));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println(Thread.currentThread() + cache.get("hello"));
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }).start();


    }

}
