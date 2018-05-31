package com.dubber.serializable.clone;

import com.dubber.serializable.javaraw.JavaSerializable;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/31
 */
public class Leader implements Cloneable,Serializable {

    private String taskName;
    private Email email;

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    /**
     * 实现接口 Cloneable、重写 clone()方法，来实现对象的前克隆
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Leader clone() throws CloneNotSupportedException {
        return (Leader) super.clone();
    }

    /**
     * 通过序列化实现深度克隆
     *
     * @return
     */
    protected Leader deepClone() {
        JavaSerializable javaSerializable = new JavaSerializable();
        return javaSerializable.deSerializable(javaSerializable.serializable(this), Leader.class);
    }


    @Override
    public String toString() {
        return "Leader{" +
                "taskName='" + taskName + '\'' +
                ", email=" + email.getContent() +
                '}';
    }
}
