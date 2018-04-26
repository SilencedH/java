package cn.youzule.blog.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.serializer.support.DeserializingConverter;
import org.springframework.core.serializer.support.SerializingConverter;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import java.io.Serializable;

/**
 * @title:
 * @description:
 * @company:
 * @author:zhaodahai
 * @date:2018/4/19 15:31
 **/

public class RedisObjectSerializer implements RedisSerializer {

    private Converter<Object,byte[]> serializer = new SerializingConverter();
    private Converter<byte[], Object> deserializer = new DeserializingConverter();

    static final byte[] EMPTY_ARRAY = new byte[0];

    private boolean isEmpty(byte[] bytes){
        return (bytes == null || bytes.length == 0);
    }


    @Override
    public byte[] serialize(Object o) throws SerializationException {
        if (o == null){
            return EMPTY_ARRAY;
        }
        try{
            return serializer.convert(o);
        }catch (Exception e){
            return EMPTY_ARRAY;
        }
    }

    @Override
    public Object deserialize(byte[] bytes) throws SerializationException {
        if(isEmpty(bytes)){
            return null;
        }
        try{
            return deserializer.convert(bytes);
        }catch (Exception e){
            throw new SerializationException("could not deserializer",e);
        }
    }
}
