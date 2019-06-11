package com.guo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 
 * StringRedisTemplate工具类
 * @author guo
 * @create 2019-06-07 23:01
 */
@Component
public class RedisService {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void set(String key, Object object, Long time) {
        // 让该方法能够支持多种数据类型存放
        if (object instanceof String) {
            setString(key, object);
        }
        // 如果存放时Set类型
        if (object instanceof Set) {
            setSet(key, object);
        }
        // 设置有效期
        if (time != null) {
            stringRedisTemplate.expire(key, time, TimeUnit.SECONDS);
        }

    }

    public void setString(String key, Object object) {
        String value = (String) object;
        // 存放string类型
        stringRedisTemplate.opsForValue().set(key, value);
    }
 // 开启事务权限
    /*public void setString(String key, Object object) {
		// stringRedisTemplate.setEnableTransactionSupport(true);
		try {
			// 开启事务 begin
			// stringRedisTemplate.multi();
			String value = (String) object;
			stringRedisTemplate.opsForValue().set(key, value);
			System.out.println("存入完毕,马上开始提交redis事务");
			// 提交事务
			// stringRedisTemplate.exec();
		} catch (Exception e) {
			// 需要回滚事务
			// stringRedisTemplate.discard();
		} finally {
			// 提交
			stringRedisTemplate.exec();
		}
	}*/
    public void setSet(String key, Object object) {
        Set<String> valueSet = (Set<String>) object;
        for (String string : valueSet) {
            stringRedisTemplate.opsForSet().add(key, string);
        }
    }

    public String getString(String key) {
        return stringRedisTemplate.opsForValue().get(key);
    }

}
