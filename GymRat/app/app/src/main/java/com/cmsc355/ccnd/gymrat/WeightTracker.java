package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.util.Calendar;
import java.util.Date;

import static com.google.android.gms.internal.zzben.NULL;


public class WeightTracker extends AppCompatActivity {

    String weight = "";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight_tracker);


    }

    public String fromEditText(EditText input) {
        weight = input.getText().toString();
        return weight;
    }

    public void submitClick(View view) {


        EditText input = (EditText) findViewById(R.id.editText);

        fromEditText(input);

        Intent intent = new Intent(this, WeightTrackerDisplay.class);
        intent.putExtra("Weight", weight);

        startActivity(intent);

    }


}
