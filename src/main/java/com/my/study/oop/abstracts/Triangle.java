package com.my.study.oop.abstracts;

public class Triangle extends Shape{
    private double a;
    private double b;
    private double c;

    public Triangle(String color, double a, double b, double c) {
        //抽象类供子类调用的父类构造器
        super(color);
        this.setSide(a, b, c);
    }

    public void setSide(double a, double b, double c) {
        if (a >= b + c || b >= a + c || c >= a + b) {
            System.err.println("三角形两边之和必须大于第三边");
            return;
        }
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public double calPerimeter() {
        return a + b + c;
    }

    @Override
    public String getType() {
        return "Triangle";
    }

    public static void main(String[] args) {
        Shape shape = new Triangle("Black", 3, 4, 5);
        System.out.println(shape.calPerimeter());
        System.out.println(shape.getColor());
        System.out.println(shape.getType());
    }
}
