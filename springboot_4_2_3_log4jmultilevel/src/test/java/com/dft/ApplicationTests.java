package com.dft;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月27日 12:08
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

  private Logger logger = Logger.getLogger(getClass());

  @Value("${spring.myvalue}")
  private String msg;

  @Test
  public void test() throws Exception {

//    logger.setLevel(Level.INFO);
    logger.info("info");
    logger.debug("debug");
    logger.error("error");

    logger.info("logging.level.com.dftspace: " + msg);
  }
}
