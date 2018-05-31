package com.dubber.serializable.xml;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/1
 */
public class Main {

    public static void main(String[] args) {
        PC  pc = new PC();
        pc.setName("联想");
        pc.setCount(4800);

        XmlSerializable xmlSerializable = new XmlSerializable();
        byte xmlByte[] = xmlSerializable.serializable(pc);
        PC pc1 = xmlSerializable.deSerializable(xmlByte,PC.class);
        System.out.println(pc1.toString());
    }
}
