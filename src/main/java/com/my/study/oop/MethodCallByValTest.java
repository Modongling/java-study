package com.my.study.oop;

public class MethodCallByValTest {

    /**
     * 局部变量
     * 栈区复制
     * @param a
     * @param b
     */
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
        System.out.println("after swap a , b:" + a + "," + b);
    }

    /**
     * 引用的拷贝
     * @param p1
     * @param p2
     */
    public static void swap(Person p1, Person p2) {
        String temp = p1.name;
        p1.name = p2.name;
        p2.name = temp;
        System.out.println("p1,p2:" + p1 + "," + p2);
        //不会影响实际的输出
        p2 = null;
        p1 = null;
    }

    private static class Person {
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

    public static void main(String[] args) {
        int a = 10;
        int b = 5;
        swap(a, b);
        System.out.println("a,b:" + a + "," + b);

        Person p1 = new Person("A", 12);
        Person p2 = new Person("B", 13);
        swap(p1, p2);
        System.out.println("p1, p2:" + p1 + "," + p2);
    }
}
