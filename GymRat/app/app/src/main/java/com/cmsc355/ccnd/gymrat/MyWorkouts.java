package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.io.Serializable;
import java.util.ArrayList;

public class MyWorkouts extends AppCompatActivity implements Serializable {

    private Workout workout = null;
    private Exercise exercise = null;
    private String exerciseNames;
    private String workoutNames;
    private String weightEquipments;
    private String numSets;
    private ListView listView;
    private DatabaseReference databaseReference;
    private FirebaseAuth firebaseAuth;
    private ArrayList<Workout> listOfWorkouts = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_workouts);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        firebaseAuth = FirebaseAuth.getInstance();

        if (getIntent().hasExtra("fromHome") && savedInstanceState == null) {
            return;
        } else {
            displayWorkouts();
        }
    }

    public void saveUserWorkoutToDatabase(Workout workout) {
        FirebaseUser user = firebaseAuth.getCurrentUser();
        databaseReference.child("list of workouts").child(user.getUid()).setValue(workout);
    }

    public void backHome(View view) {
        Intent intent = new Intent(this, HomeScreen.class);
        startActivity(intent);
    }

    public void displayWorkouts() {
        // add a workout
        Bundle extras = getIntent().getExtras();
        if (!extras.isEmpty()) {
            workoutNames = extras.getString("workout_name");
            exerciseNames = extras.getString("exercise_name");
            weightEquipments = extras.getString("weight_of_equipment");
            numSets = extras.getString("num_of_sets");

            exercise = new Exercise(exerciseNames, numSets, weightEquipments);
            workout = new Workout(workoutNames);

            workout.addExercise(exercise);
            names.add(workoutNames);
            saveUserWorkoutToDatabase(workout);

            if (!listOfWorkouts.contains(workout.getName()))
                listOfWorkouts.add(workout);

            listView = (ListView) findViewById(R.id.listView);
            ArrayAdapter adapter =
                    new ArrayAdapter(this, android.R.layout.simple_list_item_1, names); //.toString()), listOfWorkouts);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int in, long lo) {
                       if (names.get(in).equals(listOfWorkouts.get(in).getName())) {
                           Toast.makeText(MyWorkouts.this, listOfWorkouts.get(in).getExercises(), Toast.LENGTH_LONG).show();
                       }
                }
            });
        }
    }

}
