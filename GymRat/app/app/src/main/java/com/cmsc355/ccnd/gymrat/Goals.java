package com.cmsc355.ccnd.gymrat;

/*
 * Created by charles on 12/7/2017.
 */

public class Goals {


    private String name;
    private String message;

    public Goals() {

        this.name = name;
        this.message = message;
    }

    public Goals(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public void setGoalsName(String name) {
        this.name = name;
    }

    public void setMessage(String message) {

        this.message = message;
    }

    public String getGoalsName() {

        return this.name;
    }

    public String getMessage() {

        return this.message;
    }

    public String toString() {
        return "\nGoal Name " + name
                + "\nMessage " + message;
    }


}
