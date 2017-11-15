package pengfei.learn.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisMonitor {

    static class MyListener extends JedisPubSub {
        @Override
        public void onMessage(String channel, String message) {
            System.out.println(message);
            super.onMessage(channel, message);
        }

        @Override
        public void subscribe(String... channels) {
        }
    }





    public static void main(String[] args) {

        List<JedisShardInfo> shards = new ArrayList<>();


        shards.add(new JedisShardInfo("127.0.0.1"));

        ShardedJedisPool pool = new ShardedJedisPool(new GenericObjectPoolConfig(), shards);
        ShardedJedis jedis = pool.getResource();



        ShardedJedis j = new ShardedJedis(shards);




        new Thread(() -> {
            ShardedJedis shardedJedis = pool.getResource();
        }).start();
    }
}
