package com.cmsc355.ccnd.gymrat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;

public class AddWorkout extends Activity {

    private EditText editWorkoutName;
    private EditText editWeightEquipment;
    private EditText editNumOfSets;
    private String exerciseName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_workout);

        exerciseName = getIntent().getStringExtra("exercise_name_from_alist");
        Toast.makeText(AddWorkout.this, exerciseName,
                Toast.LENGTH_LONG).show();

    }

    public void onAddWorkoutClick(View view) {
        editWorkoutName = (EditText) findViewById(R.id.workoutName);
        editNumOfSets = (EditText) findViewById(R.id.numOfSets);
        editWeightEquipment = (EditText) findViewById(R.id.weight);

        String workoutName = editWorkoutName.getText().toString();
        String numSets = editNumOfSets.getText().toString();
        String equipment = editWeightEquipment.getText().toString();

        Intent intent = new Intent(AddWorkout.this, MyWorkouts.class);

        intent.putExtra("workout_name", workoutName);
        intent.putExtra("num_of_sets", numSets);
        intent.putExtra("weight_of_equipment", equipment);
        intent.putExtra("exercise_name", exerciseName);

        startActivity(intent);
    }

}
