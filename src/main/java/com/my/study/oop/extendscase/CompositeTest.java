package com.my.study.oop.extendscase;

public class CompositeTest {
    public static void main(String[] args) {
        Animal animal = new Animal();
        Bird bird = new Bird(animal);
        bird.eat();
        bird.fly();
    }
}

class Animal {
    public void eat() {
        System.out.println("eat");
    }
}

class Bird {
    //组合
    private Animal animal;

    public Bird(Animal animal) {
        this.animal = animal;
    }

    public void eat() {
        animal.eat();
    }

    public void fly() {
        System.out.println("fly");
    }
}

