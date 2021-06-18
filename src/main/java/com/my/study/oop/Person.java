package com.my.study.oop;

public class Person {
    private String name;
    private Integer age;

    public Person() {}

    public Person(Integer age) {
        this.age = age;
    }

    public Person(String name, Integer age) {
        //调用类的其他构造方法
        this(age);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        //局部变量与实例域同名
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void doSometing(String content) {
        //调用实例方法
        this.action();
        System.out.println(content);
    }

    public void action() {
        System.out.println("Eating");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        //栈内存对象引用
        Person p = new Person();
        //堆内存对象
        p.setName("ABC");
        p.setAge(123);
        p.doSometing("Working");
        System.out.println(p);
    }
}
