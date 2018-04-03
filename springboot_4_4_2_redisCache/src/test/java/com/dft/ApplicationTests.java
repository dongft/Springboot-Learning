package com.dft;

import com.dft.domain.User;
import com.dft.domain.UserRepository;
import org.junit.Before;
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
 * @Create In 2018-03-17 22:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

    @Autowired
    private UserRepository userRepository;

    String name = "王大捶捶";

    @Before
    public void before() {
        userRepository.save(new User(name, 18));
    }

    @Test
    @Transactional
    @Rollback(true)
    public void test() throws Exception {
        User u1 = userRepository.findByName(name);
        System.out.println("第一次查询: " + u1.getAge());

        User u2 = userRepository.findByName(name);
        System.out.println("第二次查询: " + u2.getAge());

        u1.setAge(20);
        userRepository.save(u1);
        User u3 = userRepository.findByName(name);
        System.out.println("第三次查询：" + u3.getAge());
    }
}
