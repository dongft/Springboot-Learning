package com.dft.domain;

import java.io.Serializable;

/**
 * @Class Name User
 * @Author dongfuting
 * @Create In 2018年03月20日 11:38
 */
public class User implements Serializable {
  private static final long serialVersionUID = -1L;

  private String name;
  private Integer age;

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }
}
