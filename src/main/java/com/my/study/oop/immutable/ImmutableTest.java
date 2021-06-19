package com.my.study.oop.immutable;

public class ImmutableTest {
    public static void main(String[] args) {
        String s = new String("Hello");
        String s2 = new String("Hello");
        //不是同一对象
        System.out.println(s == s2);
        System.out.println(s.equals(s2));
        //值相等的对象hashcode也相同
        System.out.println(s.hashCode());
        System.out.println(s2.hashCode());
    }
}
