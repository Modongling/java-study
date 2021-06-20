package com.my.study.oop.enums;

public enum Gender implements GenderInfo {
    //每个枚举值在调用的时候可以呈现不同的行为
    //匿名类
    MALE("男"){
        @Override
        public void info() {
            System.out.println("man");
        }
    },
    FEMALE("女") {
        @Override
        public void info() {
            System.out.println("woman");
        }
    };
    public String name;

    Gender(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //普通实现方式 --- 通用的行为
    @Override
    public void info() {
        System.out.println("Gender Enums");
    }
}
