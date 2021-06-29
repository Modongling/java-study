package com.my.study.oop.compare;

import java.util.Arrays;
import java.util.Comparator;

public class MyCompareDemo {

    public static void main(String[] args) {
        PersonCompare[] compares = {new PersonCompare("A", 50),
                new PersonCompare("C", 53),
                new PersonCompare("Z", 22),
                new PersonCompare("X", 21),};
        //Arrays.sort(compares);
        Arrays.sort(compares, new Comparator<PersonCompare>() {
            @Override
            public int compare(PersonCompare o1, PersonCompare o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        System.out.println(Arrays.toString(compares));
    }
}

class PersonCompare implements Comparable<PersonCompare> {
    private String name;
    private Integer age;

    public PersonCompare(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "PersonCompare{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(PersonCompare o) {
        if (o instanceof PersonCompare) {
            PersonCompare compare = o;
            if (this.age > compare.age) {
                return 1;
            } else if (this.age < compare.age) {
                return -1;
            } else {
                return 0;
            }
            //return Integer.compare(this.age, compare.age);
        }
        throw new RuntimeException("数据类型错误");
    }

}
