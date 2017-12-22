package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        Button calorieButton = (Button) findViewById(R.id.CalorieCounter);
        calorieButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeScreen.this, CaloriesCounter.class);
                startActivity(intent);
            }
        });
    }

    public void calorieCounterClick(View view) {
        Intent intent = new Intent(this, CaloriesCounter.class);
        startActivity(intent);
    }

    public void liftTipClick(View view) {
        Intent intent = new Intent(this, LiftingTips.class);
        startActivity(intent);
    }

    public void setGoalsClick(View view) {
        Intent intent = new Intent(this, SetGoals.class);
        startActivity(intent);
    }

    public void createWorkoutClick(View view) {
        Intent intent = new Intent(this, CustomWorkout.class);
        startActivity(intent);
    }

    public void profileClick(View view) {
        Intent intent = new Intent(this, MyProfile.class);
        startActivity(intent);
    }

    public void weightClick(View view) {
        Intent intent = new Intent(this, WeightTracker.class);
        startActivity(intent);
    }

    public void exampleWorkoutClick(View view) {
        Intent intent = new Intent(this, ExampleWorkout.class);
        startActivity(intent);
    }

    public void myWorksoutsClick(View view) {
        String test = "fromHome";
        Intent intent = new Intent(this, MyWorkouts.class);
        intent.putExtra("fromHome", test);
        startActivity(intent);
    }

}
