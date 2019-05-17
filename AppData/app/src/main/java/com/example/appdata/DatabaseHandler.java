package com.example.appdata;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION       = 1;
    private static final String DATABASE_NAME       = "products.db";
    public static final String TABLE_PRODUCTS       = "products";
    public static final String COLUMN_ID            = "_id";
    public static final String COLUMN_PRODUCTNAME   = "productname";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //the query
        String query = " CREATE TABLE " + TABLE_PRODUCTS + " ( " + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_PRODUCTNAME + " TEXT " + ");";
        //execute query
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_PRODUCTS);
        onCreate(db);
    }
    public  void addProduct(Products products)
    {
        //initiate content values
        ContentValues values = new ContentValues();
        //put the data to values variables
        values.put(COLUMN_PRODUCTNAME,products.get_productname());
        //initiate function getwritabledatabase to write into database
        SQLiteDatabase db = getWritableDatabase();
        //writing the datahase with insert
        db.insert(TABLE_PRODUCTS, null, values);
        //close the connection
        db.close();
    }
    public void deleteProduct(String productname)
    {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(" DELETE FROM " + TABLE_PRODUCTS + " WHERE " + COLUMN_PRODUCTNAME + "=\'" + productname + "\';");
    }
}
