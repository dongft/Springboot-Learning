package com.dft;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.dft.domain.p.User;
import com.dft.domain.p.UserRepository;
import com.dft.domain.s.Message;
import com.dft.domain.s.MessageRepository;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月19日 22:37
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private MessageRepository messageRepository;

  @Before
  public void setup(){
    userRepository.deleteAll();
    messageRepository.deleteAll();
  }

  @Test
  public void test() {
    userRepository.save(new User("王尼玛1", 18));
    userRepository.save(new User("王尼玛2", 18));
    userRepository.save(new User("王尼玛3", 18));

    Assert.assertEquals(3, userRepository.findAll().size());

    messageRepository.save(new Message("m1", "吃饭了吗"));
    messageRepository.save(new Message("m2", "吃饭了吗"));
    messageRepository.save(new Message("m3", "吃饭了吗"));

    Assert.assertEquals(3, messageRepository.findAll().size());
  }


}
