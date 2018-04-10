package com.dft.task;

import java.util.Random;
import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

/**
 * @Class Name Task
 * @Author dongfuting
 * @Create In 2018年03月22日 10:25
 */
@Component
public class Task2 {
  public static Random random = new Random();

  //注： @Async所修饰的函数不要定义为static类型，这样异步调用不会生效
  @Async
  public Future<String> doTaskOne() throws Exception {
    System.out.println("开始任务1");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务1，耗时：" + (end - start) + " 毫秒");
    return new AsyncResult<>("任务1完成");
  }

  @Async
  public Future<String> doTaskTwo() throws Exception {
    System.out.println("开始任务2");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务2，耗时：" + (end - start) + " 毫秒");
    return new AsyncResult<>("任务2完成");
  }

  @Async
  public Future<String> doTaskThree() throws Exception {
    System.out.println("开始任务3");
    long start = System.currentTimeMillis();
    Thread.sleep(random.nextInt(10000));
    long end = System.currentTimeMillis();
    System.out.println("完成任务3，耗时：" + (end - start) + " 毫秒");
    return new AsyncResult<>("任务3完成");
  }
}
