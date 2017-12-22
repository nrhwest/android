package com.cmsc355.ccnd.gymrat;

/*
 * Created by charles on 11/17/2017.
 */

import org.junit.Test;

public class SignUpTest {

    @Test
    public void signUpTestScenario1(){

        UserInformation user = new UserInformation("Charles", "Male", "5' 11'", "140lbs", "Running", "20");

        assert( user.getUserWeight() == "140lbs");

        assert( user.getProfileName() == "Charles");

        assert( user.getUserSex() == "Male");

        assert( user.getUserHeight() == "5' 11''");

        assert( user.getWorkout() == "Running");

        assert ( user.getUserAge() == "20");


    }

    @Test
    public void signUpTestScenario2(){

        UserInformation user = new UserInformation();

        user.setProfileName("Charlotte");
        user.setUserSex("Female");
        user.setUserWeight("5' 5''");
        user.setUserHeight("110 lbs");
        user.setUserAge("30");
        user.setWorkout("Curls");

        assert( user.getUserWeight() == "110 lbs");

        assert( user.getProfileName() == "Charlotte");

        assert( user.getUserSex() == "Female");

        assert( user.getUserHeight() == "5' 5''");

        assert( user.getWorkout() == "Curls");

        assert ( user.getUserAge() == "30");

    }


    @Test
    public void signUpTestScenario3(){

        UserInformation user = new UserInformation("Tyler", "Male", "5' 7''", "145lbs", "Bench Press", "24" );

        user.setWorkout("Dips");
        user.setUserSex("Female");
        user.setUserAge("25");

        assert(user.toString() == "\nUsername Tyler"
                + "\nUser Gender Female"
                + "\nUser Weight 145lbs"
                + "\nUser Height 5' 7''"
                + "\nUser Age 25"
                + "\nUser's Fav Workout Dips");

    }
}
