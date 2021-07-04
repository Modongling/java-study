package com.my.study.oop.reflect;

public class ClassDemo {
    public static void main(String[] args) {
        Class clazz = Person.class;

        Person person = new Person();
        Class clazz2 = person.getClass();

        try {
            Class clazz3 = Class.forName("com.my.study.oop.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //类加载器
        ClassLoader classLoader = ReflectDemo.class.getClassLoader();
        try {
            Class clazz4 = classLoader.loadClass("com.my.study.oop.reflect.Person");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //创建对象
        Class<Person> clazz5 = Person.class;
        try {
            Person p = clazz5.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
