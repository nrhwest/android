package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TipsForExercise extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips_for_exercise);

        TextView myTitle = (TextView) findViewById(R.id.titleWindow);
        TextView myMessage = (TextView) findViewById(R.id.messageWindow);
        Button addWorkout = (Button) findViewById(R.id.addExercise);
        Button backButton = (Button) findViewById(R.id.backButton);

        Intent incomingIntent = getIntent();
        String incomingName = incomingIntent.getStringExtra("name");
        String incomingInfo = incomingIntent.getStringExtra("info");
        //Bundle to get the picture
        Bundle extras = getIntent().getExtras();
        byte[] byteArray = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ImageView image = (ImageView) findViewById(R.id.incomingImage);

        image.setImageBitmap(bmp);
        myTitle.setText(incomingName);
        myMessage.setText(incomingInfo);

        addWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TipsForExercise.this, CustomWorkout.class);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backIntent = new Intent(TipsForExercise.this, LiftingTips.class);
                startActivity(backIntent);
            }
        });
    }

}
