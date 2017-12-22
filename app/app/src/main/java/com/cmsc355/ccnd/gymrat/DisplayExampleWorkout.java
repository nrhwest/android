package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class DisplayExampleWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_example_workout);

        Intent incomingIntent = getIntent();

        final TextView exampleList = (TextView) findViewById(R.id.exampleDisplay);
        String incomingList = incomingIntent.getStringExtra("list");
        exampleList.setText(incomingList);

        TextView exampleList2 = (TextView) findViewById(R.id.exampleDisplay1);
        String incomingList2 = incomingIntent.getStringExtra("list2");
        exampleList2.setText(incomingList2);

        TextView exampleList3 = (TextView) findViewById(R.id.exampleDisplay2);
        String incomingList3 = incomingIntent.getStringExtra("list3");
        exampleList3.setText(incomingList3);

        TextView exampleList4 = (TextView) findViewById(R.id.exampleDisplay3);
        String incomingList4 = incomingIntent.getStringExtra("list4");
        exampleList4.setText(incomingList4);

        TextView exampleList5 = (TextView) findViewById(R.id.exampleDisplay4);
        String incomingList5 = incomingIntent.getStringExtra("list5");
        exampleList5.setText(incomingList5);

        exampleList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayExampleWorkout.this, "Added to workout",
                        Toast.LENGTH_LONG).show();

            }
        });

        exampleList2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayExampleWorkout.this, "Added to workout",
                        Toast.LENGTH_LONG).show();

            }
        });

        exampleList3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayExampleWorkout.this, "Added to workout",
                        Toast.LENGTH_LONG).show();

            }
        });

        exampleList4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayExampleWorkout.this, "Added to workout",
                        Toast.LENGTH_LONG).show();

            }
        });

        exampleList5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DisplayExampleWorkout.this, "Added to workout",
                        Toast.LENGTH_LONG).show();

            }
        });

    }



}
