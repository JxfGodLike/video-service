package com.example.video;

import com.example.video.dao.UsersDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class VideoApplicationTests {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
    }
    @Test
    public void test1(){
//        stringRedisTemplate.opsForValue().append("msg","message");
        String msg = stringRedisTemplate.opsForValue().get("msg");
        System.out.println(msg);
    }

}
