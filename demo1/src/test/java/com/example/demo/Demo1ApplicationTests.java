package com.example.demo;

import com.example.demo.model.SonEntity;
import com.example.demo.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@SpringBootTest
class Demo1ApplicationTests {


    @Autowired
    private RedisTemplate<String, String> strRedisTemplate;
    @Autowired
    private RedisTemplate<String, Serializable> serializableRedisTemplate;

    @Test
    public void testString() {
        strRedisTemplate.opsForValue().set("strKey", "zwqh");
        System.out.println(strRedisTemplate.opsForValue().get("strKey"));
    }

    @Test
    public void testSerializable() {
        ArrayList<String> gifts = new ArrayList<String>();
        gifts.add("AAAAA");
        gifts.add("BBBBB");

        UserEntity user=new UserEntity();
        SonEntity son = new SonEntity();
        son.SonName = "Son";
        user.son = son;
        user.others = new HashMap<>();
        user.others.put("qqqq","qqqq");
        user.others.put("wwww","wwww");
        user.others.put("eeee","eeee");
        user.others.put("rrrr","rrrr");
        user.setBaseName("base");
        user.setGifts(gifts);
        user.setId(1L);
        user.setUserName("朝雾轻寒");
        user.setUserSex("男");
        serializableRedisTemplate.opsForValue().set("cccccc", user);
        UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("cccccc");
        System.out.println("user:"+user2.getId()+","+user2.getUserName()+","+user2.getUserSex());
    }

}
