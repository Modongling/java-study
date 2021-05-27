package com.my.study.stream.entity;

/**
 * @author mdl
 * @Created 2021/5/24 1:19
 * @Description
 */
public class Dish {
    private String name;
    private Boolean vegetarian;
    private int calories;
    private String type;

    public Dish(String name, Boolean vegetarian, int calories, String type) {
        this.name = name;
        this.vegetarian = vegetarian;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean isVegetarian() {
        return this.getVegetarian();
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type='" + type + '\'' +
                '}';
    }
}
