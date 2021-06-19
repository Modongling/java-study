package com.my.study.oop.intf;

public class Test2Impl implements Output, Product{
    //使用接口常量
    private String[] datas = new String[MAX_SIZE];
    private int dataNum = 0;
    @Override
    public void out() {
        while (dataNum > 0) {
            System.out.println(datas[0]);
            System.arraycopy(datas, 1, datas, 0, -- dataNum);
        }
    }

    @Override
    public void getData(String msg) {
        if (dataNum > MAX_SIZE) {
            System.err.println("输出队列已满");
        } else {
            datas[dataNum++] = msg;
        }
    }

    @Override
    public int getProductTime() {
        return 45;
    }

    public static void main(String[] args) {
        Output output = new Test2Impl();
        output.getData("Hello");
        output.out();
        Product product = new Test2Impl();
        System.out.println(product.getProductTime());
    }
}
