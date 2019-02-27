package com.config;

import io.lettuce.core.ReadFrom;
import io.lettuce.core.RedisURI;
import io.lettuce.core.cluster.RedisClusterClient;
import io.lettuce.core.cluster.api.StatefulRedisClusterConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.io.Serializable;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class RedisConfiguration {

    @Autowired
    private Environment environment;

    @Resource
    private LettuceConnectionFactory myLettuceConnectionFactory;

//    @Bean
//    public RedisTemplate<String, Serializable> redisTemplate(){
//        RedisTemplate<String,Serializable>  template = new RedisTemplate<String,Serializable>();
//
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setValueSerializer(new StringRedisSerializer());
//        template.setConnectionFactory(myLettuceConnectionFactory);
//        return template;
//    }

    @Bean
    public StatefulRedisClusterConnection redisClusterConnection(){

        String strRedisClusterNodes = environment.getProperty("spring.redis.cluster.nodes");
        String[] listNodesInfos = strRedisClusterNodes.split(",");

        List<RedisURI> listRedisURIs = new ArrayList<RedisURI>();
        for(String tmpNodeInfo : listNodesInfos){
            String[] tmpInfo = tmpNodeInfo.split(":");
            listRedisURIs.add(new RedisURI(tmpInfo[0],Integer.parseInt(tmpInfo[1]), Duration.ofDays(10)));
        }

        RedisClusterClient clusterClient  = RedisClusterClient.create(listRedisURIs);
        StatefulRedisClusterConnection<String, String> connection = clusterClient.connect();
        connection.setReadFrom(ReadFrom.SLAVE);

        return connection;
    }
}
