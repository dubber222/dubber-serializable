package com.dubber.serializable.json;

import com.dubber.serializable.ISerializable;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/1
 *
 * Jackson 序列化和反序列化 必须制定对应的字符集，否则乱码。
 *
 */
public class JacksonSerializable implements ISerializable{

    @Override
    public <T> byte[] serializable(T obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        String toJson = null;
        try {
            toJson = objectMapper.writeValueAsString(obj);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        System.out.println(toJson + "\n");
        try {
            return toJson.getBytes("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> T deSerializable(byte[] bytes, Class<T> tClass) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(bytes, tClass);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <T> void serializableFile(T obj, String file) {

    }

    @Override
    public <T> T deSerializableFile(String file) {
        return null;
    }
}
