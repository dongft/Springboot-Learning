package com.dft.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Class Name ScheduledTask
 * @Author dongfuting
 * @Create In 2018年03月22日 10:16
 */
@Component
public class ScheduledTask {
  private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

  @Scheduled(fixedRate = 1000)
  public void reportCurrentTime() {
    System.out.println("当前时间：" + dateFormat.format(new Date()));
  }
}
