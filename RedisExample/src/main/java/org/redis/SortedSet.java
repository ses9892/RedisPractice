package org.redis;

import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.resps.Tuple;

public class SortedSet {

    public static void main(String[] args) {
        
        Jedis jedis = new Jedis("localhost", 6379);

        jedis.zadd("sorted_set_practice", 1, "a");
        jedis.zadd("sorted_set_practice", 2, "b");
        jedis.zadd("sorted_set_practice", 3, "c");

        List<String> zrange = jedis.zrange("sorted_set_practice", 0, -1);
        System.out.println("sortedSetPractice(오름차순): " + zrange);


        List<String> zrevrange = jedis.zrevrange("sorted_set_practice", 0, -1);
        System.out.println("sortedSetPractice(내림차순): " + zrevrange);

        List<Tuple> zrevrangeWithScores = jedis.zrevrangeWithScores("sorted_set_practice", 0, -1);
        System.out.println("sortedSetPractice(내림차순 with scores):");
        for (Tuple tuple : zrevrangeWithScores) {
            // element : member , score : key?
            System.out.println("값: " + tuple.getElement() + ", 점수: " + tuple.getScore());
        }
        jedis.close();
    }
}
