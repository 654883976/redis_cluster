package com;

import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootApplication
public class DemoApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(DemoApplication.class, args);
//    }
    public static void main(String[] args) {
//    ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
//    RedisTemplate redisTemplate  = (RedisTemplate)context.getBean("redisTemplate");
//    redisTemplate.opsForValue().set("world","hello");
//    String rtnValue = (String)redisTemplate.opsForValue().get("world");
//    System.out.println("==================  "+rtnValue);

        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        StatefulRedisClusterConnection<String, String> redisClusterConnection = (StatefulRedisClusterConnection)context.getBean("redisClusterConnection");
        System.out.println(redisClusterConnection.sync().get("world"));
}
}

