package com.dubber.serializable.protobuf;

/**
 * Created on 2018/6/1.
 *
 * @author dubber
 */
public class Main {

    public static void main(String[] args) {
        ProtoSerializable protoSerializable = new ProtoSerializable();

        byte[] protoJson =  protoSerializable.serializable("c");
        System.out.println("length " + protoJson.length);

        UserProtos.User user = protoSerializable.deSerializable(protoJson,UserProtos.User.class);
        System.out.println("name = " + user.getName() + " ,age = " + user.getAge());
    }
}
