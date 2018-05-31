package com.dubber.serializable.javaraw;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/31
 *
 * 1） 若想父类的成员变量能被序列化，父类必须继承 java.io.Servializable 。
 * 2） 如果父类实现序列化，子类也已经实现序列化，继承的特性。
 */
public class Machine implements Serializable {
    private static final long serialVersionUID = 7188968349359156566L;
    String texture;

    public String getTexture() {
        return texture;
    }

    public Machine setTexture(String texture) {
        this.texture = texture;
        return this;
    }
}
