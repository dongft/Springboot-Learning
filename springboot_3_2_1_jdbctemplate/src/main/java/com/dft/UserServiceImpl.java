package com.dft;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 * @Class Name UserServiceImpl
 * @Author dongfuting
 * @Create In 2018-03-17 22:24
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Integer getAll() {
        return jdbcTemplate.queryForObject("select count(1) from USER", Integer.class);
    }

    @Override
    public void create(String name, Integer age) {
        jdbcTemplate.update("INSERT INTO USER(NAME, AGE) VALUES(?,?)", name, age);
    }

    @Override
    public void deleteByName(String name) {
        jdbcTemplate.update("DELETE FROM USER WHERE NAME = ?", name);
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.update("DELETE FROM USER ");
    }
}
