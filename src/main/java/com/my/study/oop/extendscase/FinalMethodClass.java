package com.my.study.oop.extendscase;

public class FinalMethodClass {
    public final void test(){}
    //重载
    public final void test(String content) {}

}

class Sub extends FinalMethodClass {
    //不可以重写
    //public void test() {}
}

//不可别继承的类
final class FinalClass {

}
