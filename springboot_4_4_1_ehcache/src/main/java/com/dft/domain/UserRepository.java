package com.dft.domain;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * @Class Name UserRepository
 * @Author dongfuting
 * @Create In 2018-03-17 23:32
 */
@CacheConfig(cacheNames = "users")
public interface UserRepository extends JpaRepository<User, Long> {

    //    @Cacheable(condition = "#p0.length() < 3") //满足条件才缓存
    // unless,除非条件满足，否则缓存,条件是在函数被调用之后才做判断的，所以它可以通过对result进行判断。
    // @Cacheable(unless = "#p0.length() > 3")
    User findByName(String name);

    User findByNameAndAge(String name, int age);

    @Query("from User u where u.name=:name")
    User findUser(@Param("name") String name);
}
