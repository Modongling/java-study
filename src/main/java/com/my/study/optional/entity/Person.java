package com.my.study.optional.entity;

import java.util.Optional;

public class Person {
    private Optional<Car> car;

    private Integer age;

    public Optional<Car> getCar() {
        return car;
    }

    public Integer getAge() {
        return age;
    }
}
