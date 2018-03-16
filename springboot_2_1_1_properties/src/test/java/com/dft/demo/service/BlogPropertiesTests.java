package com.dft.demo.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogPropertiesTests {

    @Autowired
    private BlogProperties blogProperties;

    @Test
    public void test(){
        Assert.assertEquals(blogProperties.getName(),"王大锤");
        Assert.assertEquals(blogProperties.getTitle(),"Springboot");
    }
}
