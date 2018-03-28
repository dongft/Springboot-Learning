package com.dft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class Name Application
 * @Author dongfuting
 * @Create In 2018年03月27日 17:25
 */
@RestController
@SpringBootApplication
public class Application {

  private Logger logger = LoggerFactory.getLogger(getClass());

  @RequestMapping(value = "/test", method = RequestMethod.GET)
  public String testLogLevel() {
    logger.debug("debug");
    logger.info("info");
    logger.error("error");
    return "";
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}
