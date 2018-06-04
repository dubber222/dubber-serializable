package com.dubber.serializable.json;

import com.alibaba.fastjson.JSON;
import com.dubber.serializable.ISerializable;

import java.io.UnsupportedEncodingException;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/1
 */
public class FastjsonSerializable implements ISerializable{

    @Override
    public <T> byte[] serializable(T obj) {
        String toJson = JSON.toJSONString(obj);
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
        try {
            return JSON.parseObject(new String(bytes,"utf-8"),tClass);
        } catch (UnsupportedEncodingException e) {
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
