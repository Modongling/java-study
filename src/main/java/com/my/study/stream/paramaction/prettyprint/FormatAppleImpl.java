package com.my.study.stream.paramaction.prettyprint;

import com.my.study.stream.paramaction.entity.Apple;

/**
 * @author mdl
 * @Created 2021/5/19 10:06
 * @Description
 */
public class FormatAppleImpl implements FormatApple{
    @Override
    public String accept(Apple apple) {
        String chars = apple.getWeight() > 150 ? "heavy" : "light";
        return "A " + chars + " " + apple.getColor() + " apple";
    }
}
