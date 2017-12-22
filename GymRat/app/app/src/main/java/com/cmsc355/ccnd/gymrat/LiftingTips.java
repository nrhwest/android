package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;

public class LiftingTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifting_tips);


        /* exerciseNames.add("Bench");
        exerciseNames.add("Push-ups");
        exerciseNames.add("Leg Press");
        exerciseNames.add("Squats");
        exerciseNames.add("Deadlift");
        exerciseNames.add("T-Bar Rows");
        exerciseNames.add("Overhead Press");
        exerciseNames.add("Shoulder Dumbell Press");
        exerciseNames.add("Dips");
        exerciseNames.add("Dumbell Curls"); */
        ListView list = (ListView) findViewById(R.id.exercise_list);
        ArrayList<String> exerciseNames = new ArrayList<>();
        exerciseNames.addAll(Arrays.asList("Bench", "Push-ups", "Leg Press", "Squats", "Deadlift" , "T-Bar Rows" ,
                "Overhead Press" , "Shoulder Dumbell Press", "Dips", "Dumbell Curls" ));
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, exerciseNames);
        list.setAdapter(adapter);


        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                      case 0: Intent benchIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        benchIntent.putExtra("name", "Tips for Bench");
                        benchIntent.putExtra("info", "Keep your chest up throughout the movement. Elbows should be tucked.");
                          Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.bench);
                          ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
                          byte[] byteArray = stream.toByteArray();
                        benchIntent.putExtra("picture", byteArray);
                        startActivity(benchIntent);
                        break;

                      case 1: Intent pushupIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        pushupIntent.putExtra("name", "Tips for Push ups");
                        pushupIntent.putExtra("info", "Squeeze your glutes. Pack elbows toward your sides. ");
                          Bitmap pushUpBmp = BitmapFactory.decodeResource(getResources(),R.drawable.pushup);
                          ByteArrayOutputStream pushUpStream = new ByteArrayOutputStream();
                        pushUpBmp.compress(Bitmap.CompressFormat.PNG, 100, pushUpStream);
                          byte[] pushUpByteArray = pushUpStream.toByteArray();
                        pushupIntent.putExtra("picture", pushUpByteArray);
                        startActivity(pushupIntent);
                        break;

                      case 2: Intent legPressIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        legPressIntent.putExtra("name","Tips for Leg Press");
                        legPressIntent.putExtra("info", "Inhale when you slowly lower the platform in place "
                                + "and press the platform until leg is fully extended in front of you. ");
                          Bitmap legPressBmp = BitmapFactory.decodeResource(getResources(),R.drawable.legpress);
                          ByteArrayOutputStream legPressStream = new ByteArrayOutputStream();
                        legPressBmp.compress(Bitmap.CompressFormat.PNG, 100, legPressStream);
                          byte[] legPressByteArray = legPressStream.toByteArray();
                        legPressIntent.putExtra("picture", legPressByteArray);
                        startActivity(legPressIntent);
                        break;

                      case 3: Intent squatIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        squatIntent.putExtra("name","Tips for Squat");
                        squatIntent.putExtra("info", "Put the bar lower on your upper back. Don't buckle your knees on the way up");
                          Bitmap squatBmp = BitmapFactory.decodeResource(getResources(),R.drawable.squat);
                          ByteArrayOutputStream squatStream = new ByteArrayOutputStream();
                        squatBmp.compress(Bitmap.CompressFormat.PNG, 100, squatStream);
                          byte[] squatByteArray = squatStream.toByteArray();
                        squatIntent.putExtra("picture", squatByteArray);
                        startActivity(squatIntent);
                        break;

                      case 4: Intent deadLiftIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        deadLiftIntent.putExtra("name","Tips for Deadlift");
                        deadLiftIntent.putExtra("info", "When grabbing the bar, bend over without bending your legs."
                                + "Do not let bar move away from your mid-foot.");
                          Bitmap deadLiftBmp = BitmapFactory.decodeResource(getResources(),R.drawable.deadlift);
                          ByteArrayOutputStream deadLiftStream = new ByteArrayOutputStream();
                        deadLiftBmp.compress(Bitmap.CompressFormat.PNG, 100, deadLiftStream);
                          byte[] deadLiftByteArray = deadLiftStream.toByteArray();
                        deadLiftIntent.putExtra("picture", deadLiftByteArray);
                        startActivity(deadLiftIntent);
                        break;

                      case 5: Intent rowIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        rowIntent.putExtra("name","Tips for T-Bar Row");
                        rowIntent.putExtra("info", "Bend over at the hips until torso is about 45 degree angle to the floor."
                                + "Keep your lower back natural arch and squeeze your shoulder blades together.");
                          Bitmap rowBmp = BitmapFactory.decodeResource(getResources(),R.drawable.tbar);
                          ByteArrayOutputStream rowStream = new ByteArrayOutputStream();
                        rowBmp.compress(Bitmap.CompressFormat.PNG, 100, rowStream);
                          byte[] rowByteArray = rowStream.toByteArray();
                        rowIntent.putExtra("picture", rowByteArray);
                        startActivity(rowIntent);
                        break;

                      case 6: Intent overHeadIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        overHeadIntent.putExtra("name","Tips for Overhead Press");
                        overHeadIntent.putExtra("info", "Keep your elbows down and tucked in. Don't bend your wrists.");
                          Bitmap overHeadBmp = BitmapFactory.decodeResource(getResources(),R.drawable.overhead);
                          ByteArrayOutputStream overHeadStream = new ByteArrayOutputStream();
                        overHeadBmp.compress(Bitmap.CompressFormat.PNG, 100, overHeadStream);
                          byte[] overHeadByteArray = overHeadStream.toByteArray();
                        overHeadIntent.putExtra("picture", overHeadByteArray);
                        startActivity(overHeadIntent);
                        break;

                      case 7: Intent shoulderPressIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        shoulderPressIntent.putExtra("name","Tips for Shoulder Press");
                        shoulderPressIntent.putExtra("info", "Don't bang the dumbells together, since it takes tension of the shoulder.");
                          Bitmap shoulderPressBmp = BitmapFactory.decodeResource(getResources(),R.drawable.shoulderpress);
                          ByteArrayOutputStream shoulderPressStream = new ByteArrayOutputStream();
                        shoulderPressBmp.compress(Bitmap.CompressFormat.PNG, 100, shoulderPressStream);
                          byte[] shoulderPressByteArray = shoulderPressStream.toByteArray();
                        shoulderPressIntent.putExtra("picture", shoulderPressByteArray);
                        startActivity(shoulderPressIntent);
                        break;

                      case 8: Intent dipIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        dipIntent.putExtra("name","Tips for Dips");
                        dipIntent.putExtra("info", "Don't lock out your elbows at the top position. "
                                + "Shoulder drops slightly below the elbow in bottom position.");
                          Bitmap dipBmp = BitmapFactory.decodeResource(getResources(),R.drawable.dips);
                          ByteArrayOutputStream dipStream = new ByteArrayOutputStream();
                        dipBmp.compress(Bitmap.CompressFormat.PNG, 100, dipStream);
                          byte[] dipByteArray = dipStream.toByteArray();
                        dipIntent.putExtra("picture", dipByteArray);
                        startActivity(dipIntent);
                        break;

                      case 9: Intent curlIntent = new Intent(LiftingTips.this, TipsForExercise.class);
                        curlIntent.putExtra("name","Tips for Barbell Curl");
                        curlIntent.putExtra("info", "Keep your elbow close to your torso . "
                                + "Exhale and curl the weights while contracting your biceps.");
                          Bitmap curlBmp = BitmapFactory.decodeResource(getResources(),R.drawable.curls);
                          ByteArrayOutputStream curlStream = new ByteArrayOutputStream();
                        curlBmp.compress(Bitmap.CompressFormat.PNG, 100, curlStream);
                          byte[] curlByteArray = curlStream.toByteArray();
                        curlIntent.putExtra("picture", curlByteArray);
                        startActivity(curlIntent);
                        break;

                      default: break;
                }


            }
        });

    }
}