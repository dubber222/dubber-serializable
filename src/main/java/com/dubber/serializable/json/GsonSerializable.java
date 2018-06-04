package com.dubber.serializable.json;

import com.dubber.serializable.ISerializable;
import com.google.gson.Gson;

/**
 * Created on 2018/6/1.
 *
 * @author dubber
 */
public class GsonSerializable implements ISerializable {

    Gson gson = null;

    public GsonSerializable() {
        gson = new Gson();
    }

    @Override
    public <T> byte[] serializable(T obj) {
        String bytesGson = gson.toJson(obj);
        return bytesGson.getBytes();
    }

    @Override
    public <T> T deSerializable(byte[] bytes, Class<T> tClass) {
        return gson.fromJson(new String(bytes), tClass);
    }

    @Override
    public <T> void serializableFile(T obj, String file) {

    }

    @Override
    public <T> T deSerializableFile(String file) {
        return null;
    }
}
