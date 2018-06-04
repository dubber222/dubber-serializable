package com.dubber.serializable.protobuf;

import com.dubber.serializable.ISerializable;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * Created on 2018/6/1.
 *
 * @author dubber
 */
public class ProtoSerializable implements ISerializable{
    @Override
    public <T> byte[] serializable(T obj) {
        UserProtos.User user = UserProtos.User.newBuilder().setName("睿睿小王子").setAge(1).build();
        return user.toByteArray();
    }

    @Override
    public <T> T deSerializable(byte[] bytes, Class<T> tClass) {
        try {
            UserProtos.User user = UserProtos.User.parseFrom(bytes);
            return (T) user;
        } catch (InvalidProtocolBufferException e) {
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
