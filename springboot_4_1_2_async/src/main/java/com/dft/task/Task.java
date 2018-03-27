package com.dft.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Class Name Task
 * @Author dongfuting
 * @Create In 2018年03月22日 10:25
 */
@Component
public class Task {
  public static Random random = new Random();

  //注： @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
  @Async
  public void doTaskOne() throws Exception {
    System.out.println("开始任务1");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务1，耗时：" + (end - start) + " 毫秒");
  }

  @Async
  public void doTaskTwo() throws Exception {
    System.out.println("开始任务2");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务2，耗时：" + (end - start) + " 毫秒");
  }

  @Async
  public void doTaskThree() throws Exception {
    System.out.println("开始任务3");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务3，耗时：" + (end - start) + " 毫秒");
  }
}
