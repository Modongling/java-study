package com.my.study.stream.paramaction.predicate;

import com.my.study.stream.paramaction.entity.Apple;

/**
 * @author mdl
 * @Created 2021/5/18 14:23
 * @Description 实现谓词建模，策略模式
 */
public class ApplePredicateImpl implements ApplePredicate{

    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
