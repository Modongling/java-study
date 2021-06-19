package com.my.study.oop.immutable;

public class FinalReference {
    private final A a;

    public FinalReference(A a) {
        this.a = new A(a.getName());
    }

    public A getA() {
        return new A(a.getName());
    }

    public static void main(String[] args) {
        A a = new A("a");
        FinalReference f = new FinalReference(a);
        System.out.println(f.getA().getName());
        a.setName("b");
        System.out.println(f.getA().getName());
    }
}

class A {
    private String name;

    public A() {
    }

    public A(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
