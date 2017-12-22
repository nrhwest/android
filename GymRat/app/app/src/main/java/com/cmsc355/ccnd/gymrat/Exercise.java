package com.cmsc355.ccnd.gymrat;

/**
 * Created by nathanwest on 11/16/17.
 */

public class Exercise {

    private String name;
    private String sets;
    private String weight;
    private int id;

    public Exercise( ) {
        name = "";
        sets = "";
        weight = "";
    }

    public Exercise(String name, String sets, String weight) {
        this.name = name;
        this.sets = sets;
        this.weight = weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSets(String sets) {
        this.sets = sets;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getSets() {
        return sets;
    }

    public String getWeight() {
        return weight;
    }

    public String toString() {
        return "Exercise: " + name
                + "\nNumber of Sets: " + sets
                + "\nWeight of Equipment: " + weight + "\n";
    }
}
