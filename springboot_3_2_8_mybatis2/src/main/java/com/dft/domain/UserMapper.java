package com.dft.domain;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

/**
 * @Class Name UserMapper
 * @Author dongfuting
 * @Create In 2018年03月20日 14:29
 */
@Mapper
public interface UserMapper {

  @Select("select * from user where name =#{name}")
  User findByName(@Param("name") String name);

  @Results({@Result(property = "name", column = "name"), @Result(property = "age", column = "age")})
  @Select("select name ,age from user")
  List<User> findAll();

  @Insert({"insert into user(name,age) values(#{name},#{age})"})
  int insert(@Param("name") String name, @Param("age") Integer age);

  @Insert("insert into user(name,age) values(#{name},#{age})")
  int insertByUser(User user);

  @Insert("insert into user(name,age) values(#{name,jdbcType=VARCHAR},#{age,jdbcType=INTEGER})")
  int insertByMap(Map<String, Object> map);

  @Update("update user set age=#{age} where name=#{name}")
  int update(User user);

  @Delete("delete from user where id=#{id}")
  int delete(Long id);

}
