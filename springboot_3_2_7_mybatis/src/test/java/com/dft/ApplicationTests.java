package com.dft;

import com.dft.domain.User;
import com.dft.domain.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

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
  @Transactional //不加这个，回滚不生效
  @Rollback(true)
  public void test() {
    userMapper.insert("王尼玛", 19);
    Assert.assertEquals(19, userMapper.findByName("王尼玛").getAge().intValue());
  }
}
