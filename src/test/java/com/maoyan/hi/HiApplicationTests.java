package com.maoyan.hi;

import com.maoyan.hi.Entity.User;
import com.maoyan.hi.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HiApplicationTests {

    @Autowired
    UserMapper mapper;

    @Test
    public void insert() {
        User user = new User();
        user.setName("范玮琪");
//        user.setId(3);
        user.setGender(1);
        Assert.assertTrue(mapper.addUser(user) > 0);
        // 成功直接拿会写的 ID
        System.err.println("\n插入成功 ID 为：" + user.getId());
    }
}

