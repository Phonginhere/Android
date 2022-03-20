package com.example.sqllitetutorial.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.sqllitetutorial.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMNS_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMNS_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMNS_ACTIVE_CUSTOMER = "ACTIVE_CUSTOMER";
    public static final String COLUMNS_ID = "ID";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "customer.db", null, 1);

    }

    //this is the first time a db is created. There should be code in here to create a new database
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
            String createTableStatement = "CREATE TABLE " + CUSTOMER_TABLE + " (" + COLUMNS_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMNS_CUSTOMER_NAME + " TEXT, " + COLUMNS_CUSTOMER_AGE + " INT, " + COLUMNS_ACTIVE_CUSTOMER + " BOOL)";

        sqLiteDatabase.execSQL(createTableStatement);
    }

    //this is called if the db version number changed. It prevents previous apps from breaking when you change the database design.
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean addOne(Customer customer){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMNS_CUSTOMER_NAME, customer.getName());
        cv.put(COLUMNS_CUSTOMER_AGE, customer.getAge());
        cv.put(COLUMNS_ACTIVE_CUSTOMER, customer.isActive());
        long insert = db.insert(CUSTOMER_TABLE, null, cv);
        if(insert == -1){
                return false;
        }
        return true;
    }

    public List<Customer> getEveryOne(){
        List<Customer> returnList = new ArrayList<>();
        //get Data from the database
        String queryString = "SELECT * FROM "+ CUSTOMER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst()){
            //loop through the cursor (result set) and create new customer objects. Put them into the return first
            do{
                int customerId = cursor.getInt(0);
                String customerName = cursor.getString(1);
                int customerAge = cursor.getInt(2);
                boolean customerActive = cursor.getInt(3) == 1 ? true: false;
                Customer newCustomer = new Customer(customerId, customerName, customerAge, customerActive);
                returnList.add(newCustomer);
            }while (cursor.moveToNext());
        }else {
                //failure . do not add anything to the list.

        }
        //close both the cursor add anything in the list.
        cursor.close();
        db.close();
        return returnList;
    }

    public boolean deleteOne(Customer customer){
        //find customerModel in the db. If it found, delete it and return true
        //if it is not found, return false
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + CUSTOMER_TABLE + " WHERE "+COLUMNS_ID + " = " + customer.getId();
        Cursor cursor = db.rawQuery(queryString, null);
        if(cursor.moveToFirst()){
            return true;
        }else{
            return false;
        }
    }
}
