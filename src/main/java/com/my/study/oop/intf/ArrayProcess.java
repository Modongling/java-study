package com.my.study.oop.intf;

import java.util.Arrays;

public class ArrayProcess {
    public void process(int[] target, Command command) {
        command.process(target);
    }

    public static void main(String[] args) {
        ArrayProcess arrayProcess = new ArrayProcess();
        int[] target = {1, 2, 3};
        arrayProcess.process(target, new PrintCommand());
        arrayProcess.process(target, target1 ->
            System.out.println(Arrays.stream(target).sum()));
    }
}
