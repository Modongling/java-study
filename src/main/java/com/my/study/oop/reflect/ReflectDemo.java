package com.my.study.oop.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args) {
        try {
            //对象创建
            Class clazz = Class.forName("com.my.study.oop.reflect.Person");
            Constructor constructor = clazz.getConstructor(String.class, Integer.class);
            Object tom = constructor.newInstance("Tom", 12);
            System.out.println((Person)tom);

            //获取属性
            Field name = clazz.getDeclaredField("name");
            //允许访问私有变量
            name.setAccessible(true);
            name.set(tom, "Jerry");
            System.out.println(tom);

            //调用方法
            Method action = clazz.getDeclaredMethod("action");
            action.invoke(tom);
            //私有带参数的方法
            Method method = clazz.getDeclaredMethod("method", String.class);
            method.setAccessible(true);
            method.invoke(tom, "private");
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
}
