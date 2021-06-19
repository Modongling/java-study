package com.my.study.oop.object;

import java.util.Objects;

public class EqualsTest {
    public static void main(String[] args) {
        String s = "ab";
        String s2 = "a";
        String s3 = "b";
        //编译期不能确定
        String s4 = s2 + s3;
        //在Heap中开辟新内存存储
        String s5 = new String("ab");
        String s6 = "a" + "b";

        System.out.println(s == s4);
        System.out.println(s == s5);
        //编译期引用的是常量池的同一个对象
        System.out.println(s == s6);
    }
}

class A {
    private String name;

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        //同一对象
        if (this == o) {
            return true;
        }
        //o是A对象
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        A a = (A) o;
        //当前对象与o的属性相等
        return Objects.equals(name, a.name);
    }

    /**
     * 重写hashcode
     * @return
     */
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
