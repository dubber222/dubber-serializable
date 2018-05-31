package com.dubber.serializable.javaraw;

import java.io.File;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/31
 *
 * 对 java 序列化的一些学习，包括序列化的范围，序列化实现形式。
 */
public class Main {
    public static void main(String[] args) {
        Car car = (Car) new Car().newBuilder()
                .setName("起亚")
                .setVersion("K2")
                .setPrice(11000.98)
                .setNum(10)
                .setOwner("安安小公主").setTexture("钢铁");

        JavaSerializable serializable = new JavaSerializable();
        /*byte[] carByte = serializable.serializable(car);*/
        /*System.out.println(serializable.deSerializable(carByte,Car.class).toString());*/

        serializable.serializableFile(car,"d:/car.txt");
        System.out.println(serializable.deSerializableFile("d:/car.txt").toString());

        System.out.println(new File("d:/car.txt").length());
    }
}
