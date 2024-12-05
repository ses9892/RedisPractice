package org.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.HashMap;

public class HashPractice {

    public static void main(String[] args) {
        try(var jedisPool = new JedisPool("127.0.0.1", 6379)){
            Jedis jedis = jedisPool.getResource();

//            addJedisMap("looco" , "ses1238@gmail.com" , jedis);
            String name = getJedisMap(jedis, "name");
            System.out.println("name : " + name);


        }
    }

    /**
     * Redis Map Type Add
     * @param name
     * @param email
     * @param jedis
     */
    public static void addJedisMap(String name, String email , Jedis jedis){
        HashMap<String, String> dummyMap = new HashMap<>();
        dummyMap.put("name", name);
        dummyMap.put("email", email);

        jedis.hset("hash_practice", dummyMap);
    }

    public static String getJedisMap(Jedis jedis , String field){
        return jedis.hget("hash_practice", field);
    }
}
