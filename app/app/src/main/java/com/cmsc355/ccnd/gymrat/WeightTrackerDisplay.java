package com.cmsc355.ccnd.gymrat;

import android.app.ListActivity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Date;

public class WeightTrackerDisplay extends AppCompatActivity {


    ArrayList<String> listItems = new ArrayList<String>();

    ArrayAdapter<String> adapter;

    String weight;

    // ListView list = (ListView) findViewById(R.id.listView);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker_display);


        Bundle extras = getIntent().getExtras();
        weight = extras.getString("Weight");
        //String date = extras.getString("date");
        ListView list = (ListView) findViewById(R.id.listView);
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listItems);
        listItems.add("Your Current Weight Is: " + weight);

        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }







}
