package com.cmsc355.ccnd.gymrat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
    * Created by Davis on 11/9/17.
*/


public class CaloriesCounterDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "FoodDataBase.db";
    public static final String TABLE_GOALS = "Food";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_GOAL_NAME = "goalname";
    public static final String COLUMN_GOAL_MESSAGE = "goalmessage";
    public static final String COLUMN_FOOD = "foodname";
    public static final String COLUMN_CALORIES = "calories";
    public static final String COLUMN_FOOD_NAME = "foodname";
    public static final String COLUMN_CALORIE = "calories";


    public CaloriesCounterDatabase(Context context, String name,
                                       SQLiteDatabase.CursorFactory factory, int version) {
            super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String table = "CREATE TABLE " + TABLE_GOALS + " ("


                    + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_FOOD_NAME + " TEXT,"
                    + COLUMN_CALORIE + " INTEGER )";
        database.execSQL(table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_GOALS);
        onCreate(database);
    }


    public Cursor getAll() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_GOALS, new String[]{COLUMN_ID, COLUMN_GOAL_NAME,
            COLUMN_GOAL_MESSAGE}, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        } else {
            return null;
        }
    }

    //Adds data to table
    public void add(Food food) {
        ContentValues content = new ContentValues();
        content.put(COLUMN_GOAL_NAME, food.getFoodName());
        content.put(COLUMN_GOAL_MESSAGE, food.getCalories());
        content.put(COLUMN_FOOD, food.getFoodName());
        content.put(COLUMN_CALORIES, food.getCalories());

        content.put(COLUMN_FOOD_NAME, food.getFoodName());
        content.put(COLUMN_CALORIE, food.getCalories());
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(TABLE_GOALS, null, content);
        database.close();
    }


    // Deletes a data by their name
    public boolean delete(String foodName) {
        boolean finish = false;
        //String table = "SELECT * FROM " + TABLE_GOALS + " WHERE " + COLUMN_CALORIES
        String table = "SELECT * FROM " + TABLE_GOALS + " WHERE " + COLUMN_FOOD_NAME
                    + " = \"" + foodName + "\"";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(table, null);
        Food food = new Food();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            food.setId(Integer.parseInt(cursor.getString(0)));
            database.delete(TABLE_GOALS, COLUMN_ID + " = ?",
                        new String[]{String.valueOf(food.getId())});
            cursor.close();
            finish = true;
        }
        database.close();
        return finish;
    }

    //Deletes all data
    public void deleteAll() {
        String table = "DELETE FROM " + TABLE_GOALS;
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(table);
        database.close();
    }

    //Adds all the calories
    public int addValues() {
        int total = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT SUM(" + (COLUMN_CALORIE) + ") FROM " + TABLE_GOALS, null);
        if (cursor.moveToFirst()) {
            total = cursor.getInt(0);
        }
        return total;
    }
}

