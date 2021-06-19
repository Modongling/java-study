package com.my.study.oop.intf;

public class FactoryTest {
    private Output output;

    public FactoryTest() {
    }

    public FactoryTest(Output output) {
        this.output = output;
    }

    public void input(String msg){
        output.getData(msg);
    }

    public void print() {
        output.out();
    }

    public Output getOutput() {
        return new Test2Impl();
    }

    public static void main(String[] args) {
        //实际这个可以作为一个工厂对象
        FactoryTest factoryTest = new FactoryTest();
        FactoryTest out = new FactoryTest(factoryTest.getOutput());
        out.input("Hello");
        out.print();
    }
}
