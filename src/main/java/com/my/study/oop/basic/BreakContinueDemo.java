package com.my.study.oop.basic;

/**
 * break
 * continue
 * return
 */
public class BreakContinueDemo {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            if (i == 2) {
                break;
            }
        }

        outer:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.println("i:" + i + " j:" + j);
                if (j == 2) {
                    break outer;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(i);
            if (i == 1) {
                continue;
            }
            System.out.println("end");
        }
    }
}
