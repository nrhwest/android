package com.cmsc355.ccnd.gymrat;

/**
 * Created by Davis on 11/9/17.
 */

public class Food {

    private String name;
    private int    calories;
    private int id;

    public Food() {

    }

    public void setId(int id) {

        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public Food(int id, String name, int calories) {
        this.id = id;
        this.name = name;
        this.calories = calories;
    }

    public Food(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }


    public void setFoodName(String name) {

        this.name = name;
    }

    public String getFoodName() {

        return this.name;
    }

    public void setCalories(int calories) {

        this.calories = calories;
    }

    public int getCalories() {

        return this.calories;
    }
}

