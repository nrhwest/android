package com.cmsc355.ccnd.gymrat;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import static com.cmsc355.ccnd.gymrat.CaloriesCounterDatabase.COLUMN_CALORIES;


import static com.cmsc355.ccnd.gymrat.CaloriesCounterDatabase.COLUMN_CALORIE;



public class CaloriesCounter extends AppCompatActivity {

    CaloriesCounterDatabase databaseHandler;
    SimpleCursorAdapter simpleCursorAdapter;
    EditText foodEdit;
    EditText caloriesEdit;
    ListView calorieList;
    TextView calorieView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_counter);


        foodEdit = (EditText) findViewById(R.id.FoodEditText);
        caloriesEdit = (EditText) findViewById(R.id.caloriesEditText);
        calorieList = (ListView) findViewById(R.id.calorieList);
        databaseHandler = new CaloriesCounterDatabase(this, null, null, 1);
        calorieView = (TextView)findViewById(R.id.caloriesCounterText);
        displayProductList();


        int sum = databaseHandler.addValues();
        calorieView.setText(Integer.toString(sum) + " calories");
    }


    public void addFood(View view) {
        try {
            Food food = new Food(foodEdit.getText().toString(),
                    Integer.parseInt(caloriesEdit.getText().toString()));
            databaseHandler.add(food);

            foodEdit.setText("");
            caloriesEdit.setText("");
            displayProductList();
        } catch (Exception exception) {
            //Something went wrong
        }
    }

    public void deleteFood(View view) {
        if (databaseHandler.delete(foodEdit.getText().toString())) {

            foodEdit.setText("");
            caloriesEdit.setText("");
            displayProductList();
        } else {
            //food Edit is Empty, problem
        }
    }


    public void deleteAllFood(View view) {
        databaseHandler.deleteAll();

        foodEdit.setText("");
        caloriesEdit.setText("");
        calorieList.setAdapter(null);
    }

    private void displayProductList() {
        try {
            Cursor cursor = databaseHandler.getAll();
            if (cursor == null) {

                return;
            }
            if (cursor.getCount() == 0) {
                return;
            }
            String[] columns = new String[] {



                CaloriesCounterDatabase.COLUMN_FOOD_NAME,
                COLUMN_CALORIE

            };
            int[] boundTo = new int[] {
              R.id.foodAdapter,
              R.id.calorieAdapter
            };
            simpleCursorAdapter = new SimpleCursorAdapter(this,
                R.layout.food_list,
                cursor,
                columns,
                boundTo,
                0);
            calorieList.setAdapter(simpleCursorAdapter);
        } catch (Exception ex) {
            //Somehting went wrong
        }
    }

    public void refreshClick(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }


}
