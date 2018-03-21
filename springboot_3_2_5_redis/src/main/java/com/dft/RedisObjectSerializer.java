package com.dft;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

/**
 * @Class Name RedisObjectSerializer
 * @Author dongfuting
 * @Create In 2018年03月20日 11:41
 */
public class RedisObjectSerializer implements RedisSerializer<Object> {

  private Converter<Object, byte[]> serializer = new SerializingConverter();
  private Converter<byte[], Object> deserializer = new DeserializingConverter();

  static final byte[] EMPTY_ARRAY = new byte[0];

  public Object deserialize(byte[] bytes) {
    if (isEmpty(bytes)) {
      return null;
    }

    try {
      return deserializer.convert(bytes);
    } catch (Exception e) {
      throw new SerializationException("Can not deserialize", e);
    }
  }

  public byte[] serialize(Object object) {
    if (object == null) {
      return EMPTY_ARRAY;
    }
    try {
      return serializer.convert(object);
    } catch (Exception e) {
      return EMPTY_ARRAY;
    }
  }

  private boolean isEmpty(byte[] data) {
    return (data == null || data.length == 0);
  }
}
