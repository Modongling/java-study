package com.my.study.oop.intf;

public class CImpl implements InterfaceC{
    @Override
    public void msgA() {
        System.out.println("a");
    }

    @Override
    public void msgB() {
        System.out.println("b");
    }

    @Override
    public void msgC() {
        System.out.println("c");
    }

    public static void main(String[] args) {
        System.out.println(InterfaceC.I_A);
        System.out.println(InterfaceC.I_B);
        System.out.println(InterfaceC.I_C);
    }
}
