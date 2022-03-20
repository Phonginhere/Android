package com.example.foodproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.foodproject.models.Food;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String FOOD_TABLE = "FOOD_TABLE";
    public static final String COLUMNS_FOOD_NAME = "FOOD_NAME";
    public static final String COLUMNS_FOOD_DESCRIPTION = "COLUMNS_FOOD_DESCRIPTION";
    public static final String COLUMNS_FOOD_PRICE = "FOOD_PRICE";
    public static final String COLUMNS_FOOD_URL = "FOOD_URL";
    public static final String COLUMNS_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);

    }

    //this is the first time a db is created. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableStatement = "CREATE TABLE " + FOOD_TABLE + " (" + COLUMNS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMNS_FOOD_NAME + " TEXT, " + COLUMNS_FOOD_DESCRIPTION + " TEXT, " + COLUMNS_FOOD_PRICE + " DOUBLE, " + COLUMNS_FOOD_URL + " TEXT)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    //this is called if the db version number changed. It prevents previous apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Food food){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMNS_FOOD_NAME, food.getFoodName());
        cv.put(COLUMNS_FOOD_DESCRIPTION, food.getDescription());
        cv.put(COLUMNS_FOOD_PRICE, food.getPrice());
        cv.put(COLUMNS_FOOD_URL, food.getUrl());
        long insert = db.insert(FOOD_TABLE, null, cv);
        if(insert == -1){
            return false;
        }
        return true;
    }

    public ArrayList<Food> getEveryOne(){
        ArrayList<Food> returnList = new ArrayList<>();
        //get Data from the database
        String queryString = "SELECT * FROM "+ FOOD_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            //loop through the cursor (result set) and create new customer objects. Put them into the return first
            do{
                int foodId = cursor.getInt(0);
                String foodName = cursor.getString(1);
                String foodDescription = cursor.getString(2);
                Double foodPrice =cursor.getDouble(3);
                String foodUrl = cursor.getString(4);
                Food newFood = new Food(foodId, foodName, foodDescription, foodPrice, foodUrl);
                returnList.add(newFood);
            }while (cursor.moveToNext());
        }else {
            //failure . do not add anything to the list.

        }
        //close both the cursor add anything in the list.
        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteOne(Food food){
        //find customerModel in the db. If it found, delete it and return true
        //if it is not found, return false
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + FOOD_TABLE + " WHERE "+COLUMNS_ID + " = " + food.getFoodId();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }
}
