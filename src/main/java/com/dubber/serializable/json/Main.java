package com.dubber.serializable.json;

import com.dubber.serializable.PC;

import java.io.UnsupportedEncodingException;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/6/1
 */
public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException {
        PC pc = new PC();
        pc.setName("联想");
        pc.setCount(4800);

        /**
         * fastjson
         */

        System.out.println("*************fastjson***************");
        FastjsonSerializable jsonSerializable = new FastjsonSerializable();
        byte jsonByte[] = jsonSerializable.serializable(pc);
        System.out.println("jsonByte length:" + jsonByte.length);
        PC pc1 = jsonSerializable.deSerializable(jsonByte, PC.class);
        System.out.println(pc1.toString());

        /**
         * jsckson
         */
        System.out.println("*************jsckson***************");
        JacksonSerializable jacksonSerializable = new JacksonSerializable();
        byte jsonByte2[] = jacksonSerializable.serializable(pc);
        System.out.println("jsonByte2 length:" + jsonByte2.length);

        PC pc2 = jacksonSerializable.deSerializable(jsonByte2, PC.class);
        System.out.println(pc2.toString());

        /**
         * gson
         */
        System.out.println("*************gson***************");
        GsonSerializable gsonSerializable = new GsonSerializable();
        byte jsonByte3[] = gsonSerializable.serializable(pc);
        System.out.println("jsonByte2 length:" + jsonByte3.length);

        PC pc3 = gsonSerializable.deSerializable(jsonByte3, PC.class);
        System.out.println(pc3.toString());
    }
}
