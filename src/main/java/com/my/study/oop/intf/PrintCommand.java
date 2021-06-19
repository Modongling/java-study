package com.my.study.oop.intf;

import java.util.Arrays;

public class PrintCommand implements Command {
    @Override
    public void process(int[] target) {
        System.out.println(Arrays.toString(target));
    }
}
