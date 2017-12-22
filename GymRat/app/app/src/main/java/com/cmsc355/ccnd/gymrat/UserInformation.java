package com.cmsc355.ccnd.gymrat;



/*
 * Created by charles on 11/15/2017.
 */

public class UserInformation {

    public String profileName;
    public String userSex;
    public String userWeight;
    public String userHeight;
    public String favoriteWorkout;
    public String userAge;

    public UserInformation() {
        this.profileName = profileName;
        this.userSex = getUserSex();
        this.userHeight = userHeight;
        this.userWeight = userWeight;
        this.favoriteWorkout = favoriteWorkout;
        this.userAge = userAge;

    }


    public UserInformation( String profileName, String userSex, String userWeight, String userHeight, String favWorkout, String userAge) {
        this.profileName = profileName;
        this.userSex = userSex;
        this.userWeight = userWeight;
        this.userHeight = userHeight;
        this.favoriteWorkout = favWorkout;
        this.userAge = userAge;

    }

    public void setProfileName(String profileName ) {
        this.profileName = profileName;
    }

    public void setUserSex(String userSex ) {
        this.userSex = userSex;
    }

    public void setUserWeight(String userWeight) {
        this.userWeight = userWeight;
    }

    public void setUserHeight(String userHeight ) {
        this.userHeight = userHeight;
    }

    public void setWorkout(String favoriteWorkout) {
        this.favoriteWorkout = favoriteWorkout;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getProfileName() {
        return profileName;
    }

    public String getUserSex() {
        return userSex;
    }

    public String getUserWeight() {
        return userWeight;
    }

    public String getUserHeight() {
        return userHeight;
    }

    public String getWorkout() {
        return favoriteWorkout;
    }

    public String getUserAge() {
        return userAge;
    }

    public String toString() {
        return "\nUsername " + profileName
                + "\nUser Gender " + userSex
                + "\nUser Weight " + userWeight
                + "\nUser Height " + userHeight
                + "\nUser Age " + userAge
                + "\nUser's Fav Workout " + favoriteWorkout;
    }
}
