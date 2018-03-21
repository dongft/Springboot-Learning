package com.dft;

import com.dft.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月20日 11:24
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Autowired
  private RedisTemplate<String, User> redisTemplate;

  @Test
  public void test() {
    stringRedisTemplate.opsForValue().set("k1", "王尼玛");
    Assert.assertEquals("王尼玛", stringRedisTemplate.opsForValue().get("k1"));

    User user = new User("王大锤", 18);
    redisTemplate.opsForValue().set(user.getName(), user);
    Assert.assertEquals(18, redisTemplate.opsForValue().get("王大锤").getAge().intValue());

  }

}
