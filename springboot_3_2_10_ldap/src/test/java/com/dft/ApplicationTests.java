package com.dft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月21日 11:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

  @Autowired
  private PersonRepository personRepository;

  @Test
  public void findAll() throws Exception {
    personRepository.findAll().forEach(p -> {
      System.out.println(p);
    });
  }

  @Test
  public void save()throws Exception{
    Person person=new Person();
    person.setUid("uid:1");
    person.setUserName("王尼玛");
    person.setCommonName("尼玛");
    person.setUserPassword("123123");
    personRepository.save(person);

    personRepository.findAll().forEach(p -> {
      System.out.println(p);
    });
  }
}
