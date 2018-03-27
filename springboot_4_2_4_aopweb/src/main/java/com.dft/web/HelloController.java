package com.dft.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Class Name HelloController
 * @Author dongfuting
 * @Create In 2018年03月27日 17:28
 */
@RestController
public class HelloController {

  @RequestMapping(value = "/hello", method = RequestMethod.GET)
  @ResponseBody
  public String hello() {
    return "Hello World";
  }

  @RequestMapping(value = "/hello", method = RequestMethod.POST)
  @ResponseBody
  public String hello(@RequestParam String name) {
    return "Hello " + name;
  }
}
