package com.manlesscafe.cafe2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class myDBHelper extends SQLiteOpenHelper{
    private static myDBHelper instance;
    public static synchronized myDBHelper getInstance(Context context) {
        if (instance == null) {
            instance = new myDBHelper(context, "User", null, 1);
        }
        return instance;

    }
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "User.db";
    public static final String TABLE_NAME = "User";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_PASSWORD = "password";
    /*public static final String USERNAME = "username";

    public static final String PERSONNUM_FRONT = "personnum_front";
    public static final String PERSONNUM_BACK = "personnum_back";
    public static final String PHONENUM = "phonenum";*/


    private myDBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, name, factory, version);
    }
    @Override public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE User(COLUMN_ID BIGINT(20) PRIMARY KEY, COLUMN_PASSWORD VARCHAR);");
    }
    /*@Override public void onCreate(SQLiteDatabase db)
     {
         db.execSQL("CREATE TABLE User(USERNAME VARCHAR, COLUMN_ID BIGINT(20) PRIMARY KEY, COLUMN_PASSWORD VARCHAR, PHONENUM VARCHAR, PERSONNUM_FRONT VARCHAR, PERSONNUM_BACK VARCHAR);");
     }*/
    @Override public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        if (newVersion > 1)
        {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
            db.execSQL("CREATE TABLE IF NOT EXISTS " + TABLE_NAME);
        }
    }
}
