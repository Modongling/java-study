package com.my.study.oop.extendscase;

public class Fruit {
    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void info() {
        System.out.println("weight:" + weight);
    }
}
