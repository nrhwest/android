package com.cmsc355.ccnd.gymrat;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/*
 * Created by Connor on 12/7/2017.
 */

public class SetGoalsDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "goalDataBase.db";
    public static final String TABLE_GOAL = "goal";

    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_GOAL_NAME = "goalname";
    public static final String COLUMN_GOAL_MESSAGE = "goalmessage";


    public SetGoalsDatabase(Context context, String name,
                                   SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase database) {
        String table = "CREATE TABLE " + TABLE_GOAL + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY, " + COLUMN_GOAL_NAME + " TEXT,"
                + COLUMN_GOAL_MESSAGE + " INTEGER )";
        database.execSQL(table);
    }


    @Override
    public void onUpgrade(SQLiteDatabase database, int oldVersion, int newVersion) {
        database.execSQL("DROP TABLE IF EXISTS " + TABLE_GOAL);
        onCreate(database);
    }


    public Cursor getAll() {
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.query(TABLE_GOAL, new String[]{COLUMN_ID, COLUMN_GOAL_NAME,
            COLUMN_GOAL_MESSAGE}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
            return cursor;
        } else {
            return null;
        }
    }

    //Adds data to table
    public void add(Goals goal) {
        ContentValues content = new ContentValues();
        content.put(COLUMN_GOAL_NAME, goal.getGoalsName());
        content.put(COLUMN_GOAL_MESSAGE, goal.getMessage());
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(TABLE_GOAL, null, content);
        database.close();
    }


    // Deletes a data by their name
    public boolean delete(String goalName) {
        boolean finish = false;
        String table = "SELECT * FROM " + TABLE_GOAL + " WHERE " + COLUMN_GOAL_NAME
                + " = \"" + goalName + "\"";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(table, null);
        Food food = new Food();
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            food.setId(Integer.parseInt(cursor.getString(0)));
            database.delete(TABLE_GOAL, COLUMN_ID + " = ?",
                    new String[]{String.valueOf(food.getId())});
            cursor.close();
            finish = true;
        }
        database.close();
        return finish;
    }

    //Deletes all data
    public void deleteAll() {
        String table = "DELETE FROM " + TABLE_GOAL;
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(table);
        database.close();
    }

    //Adds all the calories
    public int addValues() {
        int total = 0;
        SQLiteDatabase database = this.getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT SUM(" + (COLUMN_GOAL_MESSAGE) + ") FROM " + TABLE_GOAL, null);
        if (cursor.moveToFirst()) {
            total = cursor.getInt(0);
        }
        return total;
    }
}
