package com.my.study.stream.paramaction.predicate;

import com.my.study.stream.paramaction.entity.Apple;

/**
 * @author mdl
 * @Created 2021/5/18 14:22
 * @Description 谓词建模
 */
public interface ApplePredicate {
    boolean test(Apple apple);
}
