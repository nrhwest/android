package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class CustomWorkoutExercises extends AppCompatActivity {

    int muscleGroup;
    String[] bicepExercises = {"Dumbbell curls", "Incline dumbbell curls", "Concentration curls", "Preacher curls"};
    String[] tricepExercises = {"Skullcrushers", "Cable pushdowns", "Tricep kickbacks", "Lying tricep extensions"};
    String[] backExercises = {"Bent over rows", "T-bar rows", "Lat pulldown", "Inverted row", "One-arm row"};
    String[] legExercises = {"Deadlifts", "Barbell squats", "Leg press", "Leg curls", "Dumbbell lunges", "Calf raise"};
    String[] chestExercises = {"Barbell bench press", "Incline dumbbell bench press", "Cable crossover", "Dumbbell fly"};
    String[] shoulderExercises = {"Dumbbell lateral raise", "Dumbbell front raise", "Military press", "Cable upright row"};
    String[] absExercises = {"Bicycle kick", "Kneeling cable crunch", "Sit ups", "Plank", "Crunch twist", "Hanging leg raise"};
    String[] trapsExercises = {"Dumbbell shrugs", "Barbell shrugs"};

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_workout_exercises);

        muscleGroup = getIntent().getIntExtra("muscleGroup", 0);
        TextView header = (TextView) findViewById(R.id.muscleGroupHeader);
        setHeader(header,muscleGroup);
    }

    public void onBackClick(View view) {
        Intent intent = new Intent(this,CustomWorkout.class);
        startActivity(intent);
    }

    public void setHeader(TextView textView, int muscleGroup) {
        final ListView exercises = (ListView) (findViewById(R.id.exercisesNames));
        ArrayAdapter adapter = null;

        switch (muscleGroup) {
          case 1: textView.setText("Exercises for Biceps");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, bicepExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in , long lo ) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 2: textView.setText("Exercises for Shoulders");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, shoulderExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 3: textView.setText("Exercises for Abs");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, absExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 4: textView.setText("Exercises for Back");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, backExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 5: textView.setText("Exercises for Traps");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, trapsExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 6: textView.setText("Exercises for Chest");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, chestExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 7: textView.setText("Exercises for Triceps");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, tricepExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          case 8: textView.setText("Exercises for Legs");
                adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, legExercises);
                exercises.setAdapter(adapter);
                exercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    Intent addExercise = new Intent(CustomWorkoutExercises.this, AddWorkout.class);

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                        String name = exercises.getItemAtPosition(in).toString().trim();
                        addExercise.putExtra("exercise_name_from_alist", name);
                        startActivity(addExercise);
                    }
                });
                    break;
          default: textView.setText("Exercises for");
                    break;
        }
    }
}
