package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ExampleWorkout extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example__workout);
    }

    public void chestClick(View view) {
        Intent intent = new Intent(this, DisplayExampleWorkout.class);
        intent.putExtra("list", "Barbell Bench Press\n"
                + "\n"
                + "Sets: 4, Reps: 5-8, Rest Time: 90-180 Seconds\n"
                + "\n"
                + "Dumbbell Incline Press\n"
                + "\n"
                + "Sets: 4, Reps: 8-12, Rest Time: 90 Seconds\n"
                + "\n"
                + "Barbell Incline Bench Press\n"
                + "\n"
                + "Sets: 4, Reps: 6-10, Rest Time: 90 Seconds\n"
                + "\n"
                + "Weighted Dips (Chest Version)\n"
                + "\n"
                + "Sets: 4, Reps: 8-12, Rest Time: 2 Minutes\n"
                + "\n"
                + "Flat Dumbbell Press\n"
                + "\n"
                + "Sets: 4, Reps: 10-12, Rest Time: 1 Minute\n"
                + "\n");
        startActivity(intent);
    }

    public void shoulderClick(View view) {
        Intent intent = new Intent(this, DisplayExampleWorkout.class);
        intent.putExtra("list", "Dumbbell Shoulder Press\n"
                + "\n"
                + "Sets: 4, Reps: 5-10,Rest Time: 60-90 Seconds\n"
                + "\n"
                + "Standing Barbell Military Press\n"
                + "\n"
                + "Sets: 4, Reps: 5, Rest Time: 120 Seconds\n"
                + "\n"
                + "Dumbbell Lateral Raises\n"
                + "\n"
                + "Sets: 4, Reps: 6-10, Rest Time: 75 Seconds\n"
                + "\n"
                + "Dumbbell Arnold Press\n"
                + "\n"
                + "Sets: 3, Reps: 8-12,Rest Time: 60 Seconds\n"
                + "\n"
                + "Dumbbell Shrugs\n"
                + "\n"
                + "Sets: 4, Reps: 8-12,Rest Time: 75 Seconds\n"
                + "\n");
        startActivity(intent);
    }

    public void backClick(View view) {
        Intent intent = new Intent(this, DisplayExampleWorkout.class);
        intent.putExtra("list", "Deadlift\n"
                + "\n"
                + "Sets: 4, Reps: 3-6, Rest Time: 120 Seconds\n"
                + "\n"
                + "Seated Cable Row\n"
                + "\n"
                + "Sets: 3, Reps: 10, Rest Time: 90 Seconds\n"
                + "\n"
                + "Lateral Pull Down\n"
                + "\n"
                + "Sets: 4, Reps: 8-10, Rest Time: 75 Seconds\n"
                + "\n"
                + "Barbell Row\n"
                + "\n"
                + "Sets: 4, Reps: 8,Rest Time: 120 Seconds\n"
                + "\n"
                + "Reverse Hyper-extension\n"
                + "\n"
                + "Sets: 4, Reps: 10-12,Rest Time: 90 Seconds\n"
                + "\n");
        startActivity(intent);
    }

    public void abClick(View view) {
        Intent intent = new Intent(this, DisplayExampleWorkout.class);
        intent.putExtra("list", "Crunches\n"
                + "\n"
                + "Sets: 4, Reps: 12, Rest Time: 90 Seconds\n"
                + "\n"
                + "Bicycle Crunch\n"
                + "\n"
                + "Sets: 3, Reps: 20, Rest Time: 90 Seconds\n"
                + "\n"
                + "Barbell Rollout\n"
                + "\n"
                + "Sets: 4, Reps: 15, Rest Time: 120 Seconds\n"
                + "\n"
                + "Mountain Climber\n"
                + "\n"
                + "Sets: 3, Reps: 25,Rest Time: 120 Seconds\n"
                + "\n"
                + "Hanging Leg Raise\n"
                + "\n"
                + "Sets: 3, Reps: 10-12,Rest Time: 90 Seconds\n"
                + "\n");
        startActivity(intent);
    }

    public void legClick(View view) {
        Intent intent = new Intent(this, DisplayExampleWorkout.class);
        intent.putExtra("list", "Barbell Squat\n"
                + "Sets: 4, Reps: 4-6, Rest Time: 90-180 Seconds\n"
                + "\n");
        intent.putExtra("list2", "Dumbbell Lunge\n"
                + "Sets: 4, Reps: 12, Rest Time:60 Seconds");
        intent.putExtra("list3", "Leg Press\n"
                + "Sets: 3, Reps: 12-15, Rest Time:90 Seconds");
        intent.putExtra("list4", "Leg Extension\n"
                + "Sets: 3, Reps: 20, Rest Time: 2 Minutes");
        intent.putExtra("list5", "Calf Raises\n"
                + "Sets: 4, Reps: 12, Rest Time: 1 Minute\n");
        startActivity(intent);
    }

}
