package com.dubber.serializable.javaraw;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/31
 */
public class Car extends Machine implements Serializable {

    /**
     * 用于验证版本一致性
     */
    private static final long serialVersionUID = 3078320142839823542L;

    private String version;
    private String name;
    private double price;

    /**
     * 静态变量不被序列化
     */
    private static String owner;

    /**
     * transient 不序列化
     */
    private transient int num;


    //下面是 绕开 transient 机制的方法。
    /**
     * objectOutputStream 通过反射机制调用 private 的 writeObject 方法。  所以此方法必须是私有的。
     * @param objectOutputStream
     * @throws IOException
     */
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(num);
    }

    /**
     * objectInputStream 通过反射机制调用 private 的 readObject 方法。  所以此方法必须是私有的。
     * @param objectInputStream
     * @throws IOException
     */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        num = (int) objectInputStream.readObject();
    }

    public Car setOwner(String owner) {
        Car.owner = owner;
        return this;
    }

    public Car setNum(int num) {
        this.num = num;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public Car setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public Car setPrice(double price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "texture='" + texture + '\'' +
                ", version='" + version + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                '}';
    }

    public Car newBuilder() {
        return new Car();
    }
}
