package com.dubber.serializable.javaraw;

import java.io.*;

/**
 * 序列化，反序列化方法
 *
 * @author dubber
 * @date 2018/5/31
 */
public class JavaSerializable implements ISerializable {
    @Override
    public <T> byte[] serializable(T obj) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.flush();
                bos.close();
                oos.flush();
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return bos.toByteArray();
    }

    @Override
    public <T> void serializableFile(T obj, String file) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(file));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            flushAndClose(fos);
            flushAndClose(oos);
        }
    }


    /**
     *
     * @param bytes
     * @param tClass
     * @param <T>
     * @return
     */
    @Override
    public <T> T deSerializable(byte[] bytes, Class<T> tClass) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(bis);
            return (T) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                ois.close();
                bis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public <T> T deSerializableFile(String file) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        T obj = null;
        try {
            fis = new FileInputStream(new File(file));
            ois = new ObjectInputStream(fis);
            obj = (T) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            close(ois);
            close(fis);
        }
        return obj;
    }


    private void flushAndClose(OutputStream os) {
        if (os != null){
            try {
                os.flush();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private void close(InputStream is) {
        if (is != null){
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
