package com.xss.libraryfinal;

import redis.clients.jedis.Jedis;

public class JedisAdapter {


    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
//        jedis.set("hello","world");
//        jedis.get("hello");
//        System.out.println(jedis.get("hello"));
        jedis.lpush("listA","akl","sss","ssss","sss");
        System.out.println(jedis.lrange("listA",0,20));
        System.out.println(jedis.llen("listA"));
    }
}
