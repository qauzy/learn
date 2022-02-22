package com.example.demo;

import com.example.demo.model.SonEntity;
import com.example.demo.model.UserEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.*;
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
    public void testSerializable() throws IOException {
//        FileOutputStream fs=new FileOutputStream("D:\\foo.ser");
//        ObjectOutputStream os=new ObjectOutputStream(fs);
//        os.writeObject(myBox);
//        FileInputStream fi=new FileInputStream("F:\\foo.ser");
//        ObjectInputStream oi=new ObjectInputStream(fi);
//        Box box=(Box)oi.readObject();
        ArrayList<String> gifts = new ArrayList<String>();
        gifts.add("AAAAA");
        gifts.add("AAAAA");
        gifts.add("BBBBB");
        gifts.add("BBBBB");
        ArrayList<String> gifts2 = new ArrayList<String>();
        gifts2.add("CCCCC");
        gifts2.add("DDDDD");
        gifts2.add("DDDDD");
        UserEntity user=new UserEntity();
        SonEntity son = new SonEntity();
        son.SonName = "ZZZZZZZZZZZZZZZZZZZ";
        user.son = son;
        user.others = new HashMap<>();
        user.others2 = new HashMap<>();
        user.others.put("1qqqq","1qqqq");
        user.others.put("2wwww","2wwww");
        user.others.put("3eeee","3eeee");
        user.others.put("4rrrr","4rrrr");

        user.others2.put("1tttt","1tttt");
        user.setBaseName("base");
        user.gifts2 = gifts2;
        user.setGifts(gifts);
        user.setId(1L);
        user.setUserName("1111111");
        user.setUserSex("222222222dasdd");
//        os.writeObject(user.others);
//
//        os.writeObject(user.others2);
        serializableRedisTemplate.opsForValue().set("cccccc", user);
        UserEntity user2 = (UserEntity) serializableRedisTemplate.opsForValue().get("cccccc");
        System.out.println("user:"+user2.getId()+","+user2.getUserName()+","+user2.getUserSex());
    }

}
