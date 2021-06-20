package com.my.study.oop.innerclass;

public class NoneStaticClassTestOuter {
    //outer成员变量
    private double weight;
    //外部类成员变量
    private String name = "Outer-name";

    public NoneStaticClassTestOuter() {
    }

    public NoneStaticClassTestOuter(double weight) {
        this.weight = weight;
    }

    public class NoneStaticClassInner {
        private double length;
        private String color;
        //内部类成员变量
        private String name = "Inner-name";
        public NoneStaticClassInner() {
        }

        public NoneStaticClassInner(double length, String color) {
            this.length = length;
            this.color = color;
        }

        public double getLength() {
            return length;
        }

        public void setLength(double length) {
            this.length = length;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void innerMethod() {
            //访问外部类成员变量
            System.out.println("Inner method" + "outer:" + weight);
            String name = "内部类局部变量";
            //访问同名变量的情况
            System.out.println(name);
            System.out.println(this.name);
            System.out.println(NoneStaticClassTestOuter.this.name);
        }
    }

    public void getInfo() {
        //在外部类实例化非静态内部类
        //访问非静态内部类实例时必须要进行实例化
        NoneStaticClassInner inner = new NoneStaticClassInner(1, "black");
        inner.innerMethod();
        System.out.println(inner.getColor());
        System.out.println(inner.getLength());
    }

    public static void main(String[] args) {
        NoneStaticClassTestOuter outer = new NoneStaticClassTestOuter(20);
        outer.getInfo();
    }
}
