package com.dft.demo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogPropertiesTests2 {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void myTest(){
        System.out.println("name:"+blogProperties.getName());
        System.out.println("nickname:"+blogProperties.getNickname());

        System.out.println("value:"+blogProperties.getValue());
        System.out.println("number:"+blogProperties.getNumber());
        System.out.println("number:"+blogProperties.getNumber2());
        System.out.println("number:"+blogProperties.getNumber3());

    }
}
