package com.dubber.serializable.xml;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/1
 */
public class PC {
    String name;
    int count;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "PC{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
