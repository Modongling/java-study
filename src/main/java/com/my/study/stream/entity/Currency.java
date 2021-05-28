package com.my.study.stream.entity;

/**
 * @author mdl
 * @Created 2021/5/28 11:52
 * @Description
 */
public class Currency {
    private String type;

    public Currency(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "type='" + type + '\'' +
                '}';
    }
}
