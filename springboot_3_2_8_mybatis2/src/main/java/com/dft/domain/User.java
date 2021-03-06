package com.dft.domain;

import javax.annotation.Generated;

/**
 * @Class Name User
 * @Author dongfuting
 * @Create In 2018年03月20日 14:27
 */
public class User {
  private static final long serialVersionUID = -1L;

  private Long id;
  private String name;
  private Integer age;

  public User(){}

  public User(String name, Integer age) {
    this.name = name;
    this.age = age;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
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
