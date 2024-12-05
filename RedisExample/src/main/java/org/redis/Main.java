package org.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.Pipeline;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        try(var jedisPool = new JedisPool("127.0.0.1", 6379)){
            try (var jedis = jedisPool.getResource()) {
                jedis.set("users:looco:email", "ses123@gmail.com");
                jedis.set("users:looco:name", "looco");
                jedis.set("users:looco:age", "28");

                Thread.sleep(2000);
                System.out.println("------------------------------------------------");

                List<String> multiGet = jedis.mget("users:looco:email", "users:looco:name", "users:looco:age");
                multiGet.forEach(System.out::println);

                Thread.sleep(2000);
                System.out.println("------------------------------------------------");

                long counter = jedis.incr("counter");
                System.out.println("counter : " + counter);

                Thread.sleep(2000);
                System.out.println("------------------------------------------------");

//                 Multiple Pipeline Executor 
                Pipeline pipelined = jedis.pipelined();
                pipelined.set("users:jinho:name", "jinho");
                pipelined.set("users:jinho:email", "ses7361@naver.com");
                pipelined.set("users:jinho:age", "20");
                List<Object> objects = pipelined.syncAndReturnAll();
                objects.forEach(i -> System.out.println(String.valueOf(i)));
            }
        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
