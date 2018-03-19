package com.dft;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Class Name ApplicationTests
 * @Author dongfuting
 * @Create In 2018年03月19日 21:34
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

  @Autowired
  @Qualifier("primaryJdbcTemplate")
  private JdbcTemplate jdbcTemplate1;

  @Autowired
  @Qualifier("secondaryJdbcTemplate")
  private JdbcTemplate jdbcTemplate2;

  @Before
  public void setup() {
    jdbcTemplate1.update("DELETE FROM USER ");
    jdbcTemplate2.update("DELETE FROM USER ");
  }

  @Test
  public void test() {
    // 往第一个数据源中插入两条数据
    jdbcTemplate1.update("INSERT INTO USER (id,name,age) VALUES (?,?,?)", 1, "王尼玛", 21);
    jdbcTemplate1.update("INSERT INTO USER (id,name,age) VALUES (?,?,?)", 2, "王大锤", 21);

    // 往第二个数据源中插入一条数据，若插入的是第一个数据源，则会主键冲突报错
    jdbcTemplate2.update("INSERT INTO USER (id,name,age) VALUES (?,?,?)", 1, "唐马儒", 21);

    // 验证插入是否成功
    Assert.assertEquals("2",
        jdbcTemplate1.queryForObject("SELECT count(1) FROM USER ", String.class));
    Assert.assertEquals("1",
        jdbcTemplate2.queryForObject("SELECT count(1) FROM USER ", String.class));
  }
}
