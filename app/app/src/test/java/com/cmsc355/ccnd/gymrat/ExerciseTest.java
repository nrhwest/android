package com.cmsc355.ccnd.gymrat;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by nathanwest on 11/17/17.
 */
public class ExerciseTest {

    Exercise exercise = new Exercise();
    @Test
    public void setName() throws Exception {
        String expected = "Deadlifts";
        exercise.setName("Deadlifts");
        assertEquals(expected, exercise.getName());
    }

    @Test
    public void setSets() throws Exception {
        String expected = "4";
        exercise.setSets("4");
        assertEquals(expected, exercise.getSets());
    }

    @Test
    public void setWeight() throws Exception {
        String expected = "50 lb";
        exercise.setWeight("50 lb");
        assertEquals(expected, exercise.getWeight());
    }

    @Test
    public void getName() throws Exception {
        String test = "Flabbanabba";
        assertNotEquals(test, exercise.getName());
    }

    @Test
    public void getSets() throws Exception {
        String test = "542653";
        assertNotEquals(test, exercise.getSets());
    }

    @Test
    public void getWeight() throws Exception {
        String test = "9573659574 lb";
        assertNotEquals(test, exercise.getWeight());
    }

}