package org.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.List;

public class ListPractice {
    public static void main(String[] args) {

        try(var jedisPool = new JedisPool("127.0.0.1", 6379)) {
            Jedis jedis = jedisPool.getResource();

            // brLpop , brRpop 은 timeout동안 데이터가 pop될때까지 blocking을 제공한다.
            List<String> listPractice = jedis.brpop(10, "list_practice");
            // Thread blocked
            System.out.println("List after pop: " + listPractice);

        }catch (Exception e) {

        }
    }
}
