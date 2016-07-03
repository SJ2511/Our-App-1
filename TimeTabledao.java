package com.example.dell.intents;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL on 6/29/2016.
 */
public class TimeTabledao {
    SQLiteDatabase db = null;

    public void addRecords(Context context) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getWritableDatabase();
        db.beginTransaction();
        String insertStatement = " insert or replace into " + UtilConstants.TIME_TABLE_NAME + "( " + UtilConstants.DAY + " , " +
                UtilConstants.COURSE + " , " + UtilConstants.TYPE + " , " + UtilConstants.VENUE + " , " + UtilConstants.PROFESSOR + " , " + UtilConstants.FROMTIME +
                " , " + UtilConstants.TOTIME + ")" + " values(?,?,?,?,?,?,?) ";
        db.execSQL(insertStatement, new String[]{"Monday", "MTL100", "L", "LH102", "ABCD", "10 AM", "12 AM"});
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }

    public List<Timetable> retrieveRecords(Context context) {
        List<Timetable> timetableList = new ArrayList<>();
        Timetable timetable = null;
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        String query = " select " + UtilConstants.DAY + " , " + UtilConstants.COURSE + " , " + UtilConstants.TYPE + " , " + UtilConstants.VENUE + " , "
                + UtilConstants.PROFESSOR + " , " + UtilConstants.FROMTIME + " , " + UtilConstants.TOTIME + " , " + UtilConstants.ID + " from " + UtilConstants.TIME_TABLE_NAME;

        Cursor cursor = db.rawQuery(query, new String[]{});


        if (cursor.moveToFirst()) {
            do {
                timetable = new Timetable();
                timetable.setDay(cursor.getString(0));
                timetable.setFromtime(cursor.getString(5));
                timetable.setCourse(cursor.getString(1));
                timetable.setType(cursor.getString(2));
                timetable.setVenue(cursor.getString(3));
                timetable.setFaculty(cursor.getString(4));
                timetable.setTotime(cursor.getString(6));
                timetable.setId(cursor.getInt(7));


                timetableList.add(timetable);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return timetableList;


    }

    public void deleteRecords(Context context, int id) {
        DatabaseHandler databaseHandler = new DatabaseHandler(context);
        db = databaseHandler.getReadableDatabase();
        db.beginTransaction();
        String query = " delete " + " from " + UtilConstants.TIME_TABLE_NAME + " where " + UtilConstants.ID + " = " + id;
        db.execSQL(query);
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
    }
}
