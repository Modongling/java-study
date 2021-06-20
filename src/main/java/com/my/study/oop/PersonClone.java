package com.my.study.oop;

public class PersonClone implements Cloneable{
    private String name;

    public PersonClone(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected PersonClone clone() throws CloneNotSupportedException {
        return (PersonClone) super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PersonClone personClone = new PersonClone("Tom");
        PersonClone personClone2 = personClone.clone();
        //复制出一个新的堆内存对象
        System.out.println(personClone == personClone2);
        //堆内存变量引用是同一个
        System.out.println(personClone.name == personClone2.name);
    }
}
