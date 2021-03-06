package com.dft.domain;

/**
 * @Class Name User
 * @Author dongfuting
 * @Create In 2018年03月20日 14:27
 */
public class User {
  private static final long serialVersionUID = -1L;

  private String username;
  private Integer age;

  public User(){}

  public User(String username, Integer age) {
    this.username = username;
    this.age = age;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

}
