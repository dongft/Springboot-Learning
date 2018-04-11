package com.dft.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class Name HelloController
 * @Author dongfuting
 * @Create In 2018年04月11日 20:16
 */
@RestController
public class HelloController {

  @RequestMapping(name = "/hello", method = RequestMethod.GET)
  public String hello() {
    return "hello world.";
  }
}
