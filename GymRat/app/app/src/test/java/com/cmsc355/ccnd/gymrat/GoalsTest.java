package com.cmsc355.ccnd.gymrat;

/*
 * Created by charles on 12/7/2017.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoalsTest {
    Goals goals = new Goals();

    @Test
    public void goalsScenario1(){

        Goals goal = new Goals("Bench","Bench more than 5 pounds.");

        assert( goal.getGoalsName() == "Bench");

        assert( goal.getMessage() == "Bench more than 5 pounds.");

    }

    @Test
    public void GoalsScenario2(){

        Goals goal = new Goals();

        goal.setGoalsName("Deadlifts");
        goal.setMessage("Deadlift a car");


        assert( goals.getGoalsName() == "Deadlifts");

        assert( goals.getMessage() == "Deadlift a car");

    }

    @Test
    public void signUpTestScenario3(){

        Goals goal = new Goals("Bench","Bench more than 5 pounds.");

        goal.setGoalsName("Dips");
        goal.setMessage("Do a bunch of dips");


        assert(goal.toString() == "\nGoal Name Dips"
                + "\nMessage Do a bunch of dips");

    }
}
