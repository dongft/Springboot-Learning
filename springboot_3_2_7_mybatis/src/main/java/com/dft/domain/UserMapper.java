package com.dft.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Class Name UserMapper
 * @Author dongfuting
 * @Create In 2018年03月20日 14:29
 */
@Mapper
public interface UserMapper {
  @Select("SELECT * from user where name =#{name}")
  User findByName(@Param("name") String name);

  @Insert({"insert into user(name,age) values(#{name},#{age})"})
  int insert(@Param("name") String name, @Param("age") Integer age);

}
