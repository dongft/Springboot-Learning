package com.dft;

import com.dft.task.Task;
import com.dft.task.Task2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.Future;

/**
 * @Class Name ApplicationTest
 * @Author dongfuting
 * @Create In 2018年03月22日 12:07
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTest {
  @Autowired
  private Task task;

  @Autowired
  private Task2 task2;

  @Test
  public void test() throws Exception {
    task.doTaskOne();
    task.doTaskTwo();
    task.doTaskThree();

    Thread.sleep(10000);
  }

  @Test
  public void test2() throws Exception {
    long start = System.currentTimeMillis();

    Future<String> t1 = task2.doTaskOne();
    Future<String> t2 = task2.doTaskTwo();
    Future<String> t3 = task2.doTaskThree();

    while (true) {
      if (t1.isDone() && t2.isDone() && t3.isDone()) {
        // 三个任务都完成了
        System.out.println(t1.get());
        System.out.println(t2.get());
        System.out.println(t3.get());
        break;
      }
      Thread.sleep(1000);
    }

    long end = System.currentTimeMillis();
    System.out.println("任务全部完成，用时：" + (end - start) + "毫秒.");
  }
}
