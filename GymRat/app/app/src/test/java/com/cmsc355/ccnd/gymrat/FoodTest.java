package com.cmsc355.ccnd.gymrat;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by Davis on 11/17/17.
 */

public class FoodTest {
    Food food = new Food();

    @Test
    public void setFoodName() throws Exception {
        String expected = "Pizza";
        food.setFoodName("Pizza");
        assertEquals(expected, food.getFoodName());

    }

    @Test
    public void setCaloriesTest() throws Exception {
        int expected = 100;
        food.setCalories(100);
        assertEquals(expected, food.getCalories());

    }

    @Test
    public void setIdTest() throws Exception {
        int expected = 1;
        food.setId(1);
        assertEquals(expected, food.getId());
    }
}
