package com.dubber.serializable.javaraw;

import java.io.Serializable;

/**
 * Created on 2018/6/1.
 *
 * @author dubber
 */
public class User implements Serializable{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

}
