package com.dft;

import com.dft.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Class Name RedisConfig
 * @Author dongfuting
 * @Create In 2018年03月20日 11:56
 */
@Configuration
public class RedisConfig {

  @Bean
  JedisConnectionFactory jedisConnectionFactory() {
    return new JedisConnectionFactory();
  }

  @Bean
  public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory factory) {
    RedisTemplate<String, User> template = new RedisTemplate<>();
    template.setConnectionFactory(factory);
    template.setKeySerializer(new StringRedisSerializer());
    template.setValueSerializer(new RedisObjectSerializer());
    return template;
  }
}
