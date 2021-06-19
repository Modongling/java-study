package com.my.study.oop.abstracts;

public abstract class Shape {
    private String color;
    {
        System.out.println("抽象类Shape初始化块");
    }
    protected abstract double calPerimeter();

    protected abstract String getType();

    public Shape(){}
    public Shape(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

}
