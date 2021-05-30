package com.my.study.parallel.stream;

/**
 * @author mdl
 * @Created 2021/5/30 14:25
 * @Description
 */
public class SpliteratorDemo {
    public static int foundWord(String s) {
        int count = 0;
        boolean space = true;
        for (char c : s.toCharArray()) {
            if (Character.isWhitespace(c)) {
                space = true;
            } else {
                if (space) {
                    count++;
                }
                space = false;
            }
        }
        return count;
    }
}
