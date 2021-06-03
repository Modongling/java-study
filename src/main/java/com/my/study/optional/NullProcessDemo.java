package com.my.study.optional;

import com.my.study.optional.entity.Car;
import com.my.study.optional.entity.Insurance;
import com.my.study.optional.entity.Person;

import java.util.Optional;

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
    }
}
