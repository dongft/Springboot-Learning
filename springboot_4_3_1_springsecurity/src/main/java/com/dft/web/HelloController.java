package com.dft.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Class Name HelloController
 * @Author dongfuting
 * @Create In 2018年03月28日 16:06
 */
@Controller
public class HelloController {

  @ResponseBody
  @RequestMapping("/hello")
  public String hello() {
    return "Hello";
  }

  @RequestMapping(value = "/",method = RequestMethod.GET)
  public String index(Model map) {
    map.addAttribute("host", "http://www.baidu.com");
    // return模板文件的名称，对应src/main/resources/templates/index.html
    return "index";
  }

  @RequestMapping("/login")
  public String login(){
    return "login";
  }
}
