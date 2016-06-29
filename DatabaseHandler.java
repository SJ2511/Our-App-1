package com.example.dell.intents;

/**
 * Created by DELL on 6/23/2016.
 */

//package com.example.dell.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by DELL on 6/23/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ACTIVITIES.db";
    //public static final String TABLE_NAME = "EVENTS";

    public static final int DATABASE_VERSION = 1;

    private String CREATE_LOGIN_TABLE = "CREATE TABLE " + UtilConstants.LOGIN_TABLE_NAME + " ( " + UtilConstants.NAME + " TEXT, " +
            UtilConstants.USER_NAME + " TEXT PRIMARY KEY, " + UtilConstants.PASSWORD + " TEXT ) ";
    private String CREATE_TIME_TABLE = "CREATE TABLE " + UtilConstants.TIME_TABLE_NAME + " ( " + UtilConstants.DATE + " DATE, " + UtilConstants.COURSE + " TEXT, " + UtilConstants.TYPE + " TEXT, " + UtilConstants.FROMTIME + " TEXT, " + UtilConstants.TOTIME+ " TEXT, "+UtilConstants.VENUE + " TEXT, " +
            UtilConstants.PROFESSOR + " TEXT ) ";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
  /*      db.execSQL("create table" + TABLE_NAME + "(" +
                COL_1 + " INTEGER PRIMARY KEY," + COL_2 + " DATE" + COL_3 + "TEXT" + COL_4 + "TEXT" + COL_5 + "TEXT" + COL_6 + "TEXT"
                + COL_7 + " TEXT" + ")");
*/


        db.execSQL(CREATE_LOGIN_TABLE);
        db.execSQL(CREATE_TIME_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISIS" + CREATE_LOGIN_TABLE);
        db.execSQL("DROP TABLE IF EXISTS" + CREATE_TIME_TABLE);
        onCreate(db);
    }


}
