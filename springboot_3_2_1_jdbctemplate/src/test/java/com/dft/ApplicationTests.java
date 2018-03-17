package com.dft;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018-03-17 22:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void createTest() {
        userService.create("王尼玛", 18);
        userService.create("王尼美", 18);
        userService.create("王大锤", 18);
        Assert.assertEquals(3, userService.getAll().intValue());

        userService.deleteByName("王尼美");
        Assert.assertEquals(2, userService.getAll().intValue());

        userService.deleteAll();
        Assert.assertEquals(0, userService.getAll().intValue());
    }
}
