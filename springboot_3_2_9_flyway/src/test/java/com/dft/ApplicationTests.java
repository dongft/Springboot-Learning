package com.dft;

import com.dft.service.UserService;
import org.junit.Assert;
import org.junit.Before;
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
  private UserService userSerivce;

  @Before
  public void setUp() {
    // 准备，清空user表
    userSerivce.deleteAllUsers();
  }

  @Test
  public void test() throws Exception {
    // 插入5个用户
    userSerivce.create("a", 1);
    userSerivce.create("b", 2);
    userSerivce.create("c", 3);
    userSerivce.create("d", 4);
    userSerivce.create("e", 5);

    // 查数据库，应该有5个用户
    Assert.assertEquals(5, userSerivce.getAllUsers().intValue());

    // 删除两个用户
    userSerivce.deleteByName("a");
    userSerivce.deleteByName("e");

    // 查数据库，应该有5个用户
    Assert.assertEquals(3, userSerivce.getAllUsers().intValue());

    userSerivce.deleteAllUsers();
    Assert.assertEquals(0, userSerivce.getAllUsers().intValue());

  }
}