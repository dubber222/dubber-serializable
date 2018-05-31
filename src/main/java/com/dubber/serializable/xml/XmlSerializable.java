package com.dubber.serializable.xml;

import com.dubber.serializable.ISerializable;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/1
 */
public class XmlSerializable implements ISerializable{

    XStream xStream = new XStream(new DomDriver());
    @Override
    public <T> byte[] serializable(T obj) {
        String toxml = xStream.toXML(obj);
        System.out.println(toxml + "\n");
        return toxml.getBytes();
    }

    @Override
    public <T> T deSerializable(byte[] bytes, Class<T> tClass) {
        return (T)xStream.fromXML(new String(bytes));
    }

    @Override
    public <T> void serializableFile(T obj, String file) {

    }

    @Override
    public <T> T deSerializableFile(String file) {
        return null;
    }
}
