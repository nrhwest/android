package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class CustomWorkout extends AppCompatActivity {

    int muscleGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_workout);
    }

    public void onBicepsClick(View view) {
        setMuscleGroup(1);
    }

    public void onShouldersClick(View view) {
        setMuscleGroup(2);
    }

    public void onAbsClick(View view) {
        setMuscleGroup(3);
    }

    public void onBackClick(View view) {
        setMuscleGroup(4);
    }

    public void onTrapsClick(View view) {
        setMuscleGroup(5);
    }

    public void onChestClick(View view) {
        setMuscleGroup(6);
    }

    public void onTricepsClick(View view) {
        setMuscleGroup(7);
    }

    public void onLegsClick(View view) {
        setMuscleGroup(8);
    }

    public void onGoBackClick(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    public void setMuscleGroup(int group) {
        Intent intent = new Intent(this, CustomWorkoutExercises.class);
        intent.putExtra("muscleGroup", group);
        startActivity(intent);
    }

}
