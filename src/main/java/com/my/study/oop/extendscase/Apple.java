package com.my.study.oop.extendscase;

public class Apple extends Fruit{
    private String name;

    public Apple(String name, double weight) {
        //如果父类有构造方法子类必须调用父类的构造方法，在子类构造函数的第一行
        //调用父类方法的时候也是super.method()/或者访问父类的成员变量
        //即便没有super子类也会隐式调用父类的无参构造器
        super(weight);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "name='" + name + '\'' +
                "} " + super.toString();
    }

    /**
     * 重写父类方法
     */
    @Override
    public void info() {
        System.out.println("Apple weight is " + getWeight());
    }

    public static void main(String[] args) {
        Apple apple = new Apple("Green Apple", 1.25);
        apple.info();
    }
}
