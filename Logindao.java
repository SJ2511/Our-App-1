package com.example.dell.intents;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by DELL on 6/23/2016.
 */
public class Logindao {
    SQLiteDatabase db = null;

    public boolean login(Context context, String username, String password) {
        boolean loginSuccessful = false;
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        String query = " select " + UtilConstants.USER_NAME + " from " + UtilConstants.LOGIN_TABLE_NAME + " where " + UtilConstants.USER_NAME + " = ? and " + UtilConstants.PASSWORD + " = ? ";
        Cursor cursor = db.rawQuery(query, new String[]{username, password});
        if (cursor.moveToFirst()) {
            do {
                loginSuccessful = true;
            } while (cursor.moveToNext());
        }
        db.close();
        return loginSuccessful;
    }

    public void addREcords(Context context) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getWritableDatabase();
        db.beginTransaction();
        String insertStatement = " insert or replace into " + UtilConstants.LOGIN_TABLE_NAME + "( " + UtilConstants.USER_NAME + " , " + UtilConstants.NAME + " , " + UtilConstants.PASSWORD + ")" + " values(?,?,?) ";
        db.execSQL(insertStatement, new String[]{"sj", "sakshi", "1234"});
        db.setTransactionSuccessful();
        db.endTransaction();


        String query = " select " + UtilConstants.USER_NAME + " from " + UtilConstants.LOGIN_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, new String[]{});

        if (cursor.moveToFirst()) {
            do {
                Log.d("aaa", cursor.getString(0));

            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
    }

    public void saveDataRegistered (Context context,String name,String username, String password)
    {
        DatabaseHandler databaseHandler= new DatabaseHandler(context);
        db= databaseHandler.getWritableDatabase();
        db.beginTransaction();
        String insertStatement= " insert or replace into " + UtilConstants.LOGIN_TABLE_NAME + " ( "+ UtilConstants.USER_NAME+ " , "+ UtilConstants.NAME+ " , "+ UtilConstants.PASSWORD+ " ) values( "+"'"+username+"'"+ "," +"'"+name+"'"+ "," +"'"+password+"'"+" ) ";
        db.execSQL(insertStatement);
        db.setTransactionSuccessful();
        db.endTransaction();
        String query = " select " + UtilConstants.USER_NAME + " from " + UtilConstants.LOGIN_TABLE_NAME;
        Cursor cursor = db.rawQuery(query, new String[]{});

        if (cursor.moveToFirst()) {
            do {
                Log.d("NewHere", cursor.getString(0));

            } while (cursor.moveToNext());
        }
        db.close();
    }



    }






