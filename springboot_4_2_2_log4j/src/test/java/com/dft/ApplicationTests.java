package com.dft;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.apache.log4j.Logger;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月26日 21:26
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ApplicationTests {

  private Logger logger = Logger.getLogger(getClass());

  @Test
  public void test() {
    logger.info("输出info");
    logger.debug("输出debug");
    logger.error("输出error");
  }
}
