package com.dft;

import com.dft.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.dft.domain.UserMapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月20日 14:36
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

  @Autowired
  private UserMapper userMapper;

  @Test
  @Transactional // 不加这个，回滚不生效
  @Rollback(true)
  public void test() {
    userMapper.insert("王尼玛", 19);
    Assert.assertEquals(19, userMapper.findByName("王尼玛").getAge().intValue());

    User user = new User("王大锤", 18);
    Assert.assertEquals(1, userMapper.insertByUser(user));

    Map<String, Object> map = new HashMap<>();
    map.put("age", 19);
    map.put("name", "什么鬼");
    userMapper.insertByMap(map);
    Assert.assertEquals(19, userMapper.findByName("什么鬼").getAge().intValue());

    userMapper.update(new User("什么鬼",29));
    Assert.assertEquals(29, userMapper.findByName("什么鬼").getAge().intValue());

    // findAll()
    List<User> userList=userMapper.findAll();
    userList.forEach(uu->{
      Assert.assertEquals(null,uu.getId());
      Assert.assertNotEquals(null,uu.getName());
    });
  }
}
