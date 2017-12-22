package com.cmsc355.ccnd.gymrat;

import java.util.ArrayList;
import java.util.List;

/*
 * Created by nathanwest on 11/16/17.
 */

public class Workout  {

    private String name;
    private final List<Exercise> exercises = new ArrayList<>();

    public Workout() {
        name = "";
        // exercises = null;
    }

    public Workout(String name) {
        this.name = name;
        // exercises.add(exercise);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public List<Exercise> getListOfExercises() {
        if (!exercises.isEmpty()) {
            return exercises;
        }

        return null;
    }

    public String getExercises() {
        while (!exercises.isEmpty()) {
            return exercises.toString();
        }
        return "No exercises to return";
    }

    public void addExercise(Exercise exercise) {
        exercises.add(exercise);
    }
}
