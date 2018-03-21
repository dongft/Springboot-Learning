package com.dft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Class Name UserServiceImpl
 * @Author dongfuting
 * @Create In 2018年03月20日 20:06
 */
@Service
public class UserServiceImpl implements UserService {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public void create(String name, Integer age) {
    jdbcTemplate.update("INSERT INTO USER (NAME ,AGE) VALUES (?,?)", name, age);
  }

  @Override
  public void deleteByName(String name) {
    jdbcTemplate.update("DELETE FROM USER WHERE NAME =?", name);
  }

  @Override
  public Integer getAllUsers() {
    return jdbcTemplate.queryForObject("SELECT count(1) FROM USER ", Integer.class);
  }

  @Override
  public void deleteAllUsers() {
    jdbcTemplate.update("DELETE FROM USER ");
  }
}
