package com.my.study.stream.paramaction;

/**
 * @author mdl
 * @Created 2021/5/19 10:19
 * @Description 匿名类的问题
 */
public class MeaningOfThis {
    public final int value = 4;
    public void doIt() {
        int value = 6;
        Runnable r = new Runnable() {
            public final int value = 5;
            @Override
            public void run() {
                int value = 10;
                System.out.println(this.value);
            }
        };
        r.run();
    }

    public static void main(String[] args) {
        MeaningOfThis meaningOfThis = new MeaningOfThis();
        meaningOfThis.doIt();
    }
}
