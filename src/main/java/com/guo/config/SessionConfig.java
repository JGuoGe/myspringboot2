package com.guo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

/**
 * @author guo
 * @create 2019-06-08 11:57
 */
//这个类用配置redis服务器的连接
//maxInactiveIntervalInSeconds为SpringSession的过期时间（单位：秒）
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)
public class SessionConfig {
    // 冒号后的值为没有配置文件时，制动装载的默认值
    /*@Value("${spring.redis.host:localhost}")
    String HostName;
    @Value("${spring.redis.port:6379}")
    int Port;
    @Value("${spring.redis.password}")
    String password;
    @Bean
    public JedisConnectionFactory connectionFactory() {
        System.out.println(HostName);
        System.out.println(Port);
        System.out.println(password);
        JedisConnectionFactory connection = new JedisConnectionFactory();
        connection.setPort(Port);
        connection.setHostName(HostName);
        connection.setPassword(password);
        return connection;
    }*/




}
