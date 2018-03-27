package com.dft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Class Name Application
 * @Author dongfuting
 * @Create In 2018年03月22日 10:14
 */
@SpringBootApplication
@EnableScheduling
public class Application {
  public static void main(String[] args){
    SpringApplication.run(Application.class, args);
  }
}
