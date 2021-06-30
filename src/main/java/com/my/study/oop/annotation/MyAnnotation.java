package com.my.study.oop.annotation;

import java.lang.annotation.Repeatable;

@Repeatable(MyAnnotations.class)
public @interface MyAnnotation {
    String value() default "";
}
