package com.cmsc355.ccnd.gymrat;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DisplayWorkouts extends AppCompatActivity {
    private ArrayList<Exercise> exercises = new ArrayList<>();
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_workouts);

        exercises = (ArrayList<Exercise>) getIntent().getSerializableExtra("exercises");
        list = (ListView) findViewById(R.id.listingExercises);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, exercises);
        list.setAdapter(adapter);


    }
}
