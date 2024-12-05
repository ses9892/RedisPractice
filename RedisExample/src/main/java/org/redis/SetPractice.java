package org.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;
import java.util.Set;

public class SetPractice {
    public static void main(String[] args) {

        try(var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            Jedis jedis = jedisPool.getResource();

            // SADD
            // param
            jedis.sadd("set_practice" , "1" , "2" , "3" , "4" , "5" , "6");

            
            // SCRD : 개수
            long setPractice = jedis.scard("set_practice");
            System.out.println("setPractice: " + setPractice);

            // SMEMBERS
            Set<String> setPractice1 = jedis.smembers("set_practice");
            System.out.println("setPractice1: " + setPractice1);
            
            // SISMEMBER : exists
            boolean isMember = jedis.sismember("set_practice", "3");
            System.out.println("isMember: " + isMember);



        }catch (Exception e) {

        }
    }
}
