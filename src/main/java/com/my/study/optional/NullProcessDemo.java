package com.my.study.optional;

import com.my.study.optional.entity.Car;
import com.my.study.optional.entity.Insurance;
import com.my.study.optional.entity.Person;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NullProcessDemo {

    public static void optionalDemo() {
        Optional<Car> optionalCar = Optional.empty();
        Car c = new Car();
        Optional<Car> car = Optional.of(c);
        Car c2 = null;
        Optional<Car> car2 = Optional.ofNullable(c2);
    }
    public static void getCarInsuranceName(Person person) {
        Insurance insurance = new Insurance();
        Optional<Insurance> i = Optional.ofNullable(insurance);
        Optional<String> name = i.map(Insurance::getName);

        Optional<Person> p = Optional.of(person);
        String newName = p.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName).orElse("null");

        List<Person> people = new ArrayList<>();
//        Set<String> stringSet = people.stream()
//                .map(Person::getCar)
//                .map(optCar -> optCar.flatMap(Car::getInsurance))
//                .map(optIns -> optIns.map(Insurance::getName))
//                .flatMap(Optional::stream)
//                .collect(Collectors.toSet());

        Stream<Optional<String>> stream = people.stream()
                .map(Person::getCar)
                .map(optCar -> optCar.flatMap(Car::getInsurance))
                .map(optIns -> optIns.map(Insurance::getName));
        Set<String> set = stream.filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
    }

    public static void optionalMethodDemo() {
        //get() NoSuchElementException
        //orElse() 对象不包含时提供默认值
        //orElseGet() 延迟不包含值的时候调用
        //or()
        //orElseThrow()
        //ifPresent() 存在变量执行一个参数传入
        //ifPresentOrElse()
        //ofNullable() 如果值为null返回空对象
        //不推荐使用基础类型
    }

    public static Optional<Insurance> safeFindInsurance(Optional<Person> person, Optional<Car> car) {
        return person.flatMap(p -> car.map(c -> findInsurance(p, c)));
    }

    private static Insurance findInsurance(Person p, Car c) {
        return new Insurance();
    }

    public static String getCar(Optional<Person> person, int minAge) {
        return person.filter(p -> p.getAge() >= minAge)
                .flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("NULL");
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        }catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static int readProps(Properties properties, String name) {
        return Optional.ofNullable(properties.getProperty(name))
                .flatMap(NullProcessDemo::stringToInt)
                .filter(i -> i > 0)
                .orElse(0);
    }

}
