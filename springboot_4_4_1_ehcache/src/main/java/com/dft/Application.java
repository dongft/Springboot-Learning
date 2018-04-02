package com.dft;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * @Class Name Application
 * @Author dongfuting
 * @Create In 2018-03-17 22:55
 */
@SpringBootApplication
@EnableCaching
public class Application {
  public static void main(String... args) {
    SpringApplication.run(Application.class, args);
  }
}
