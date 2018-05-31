package com.dubber.serializable.javaraw;

import java.io.IOException;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/31
 */
public interface ISerializable {
    /**
     * 序列化为二进制字节
     * @param obj
     * @param <T>
     * @return
     */
     <T> byte[] serializable(T obj);

    /**
     * 序列化到磁盘
     * @param obj
     * @param file
     * @param <T>
     */
     <T> void serializableFile(T obj,String file);

    /**
     * 反序列化为对象
     * @param bytes
     * @param tClass
     * @param <T>
     * @return
     */
     <T> T deSerializable(byte[] bytes,Class<T> tClass);

    /**
     * 从磁盘反序列化为对象
     * @param file
     * @param <T>
     * @return
     */
     <T> T deSerializableFile(String file);
}
