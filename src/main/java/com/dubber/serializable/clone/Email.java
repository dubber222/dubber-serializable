package com.dubber.serializable.clone;

import java.io.Serializable;

/**
 * Demo class
 *
 * @author dubber
 * @date 2018/5/31
 */
public class Email implements Serializable {

    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
