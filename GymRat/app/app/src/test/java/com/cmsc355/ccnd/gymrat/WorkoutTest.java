package com.cmsc355.ccnd.gymrat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nathanwest on 11/17/17.
 */

public class WorkoutTest {

    Workout workout = new Workout();
    @Test
    public void setName() throws Exception {
        String expected = "Day 1 Biceps";
        workout.setName("Day 1 Biceps");
        assertEquals(expected, workout.getName());
    }

    @Test
    public void getName() throws Exception {
        String expected = "Day 1 Biceps";
        workout.setName("Day 1 Biceps");
        String actual = workout.getName();
        assertEquals(expected, actual);
    }

    @Test
    public void getListOfExercises() throws Exception {
        Exercise exercise = new Exercise("Bicep curls", "4", "30");
        Exercise exercise1 = new Exercise("Skullcrushers", "4", "80");
        workout.addExercise(exercise);
        workout.addExercise(exercise1);
        assertNotNull(workout.getListOfExercises());
    }

    @Test
    public void getExercises() throws Exception {
        Exercise exercise = new Exercise("Bicep curls", "4", "30");
        Exercise exercise1 = new Exercise("Skullcrushers", "4", "80");
        workout.addExercise(exercise);
        workout.addExercise(exercise1);
        String test = "Bicep curls";
        assertNotEquals(test, workout.getExercises());
    }

}