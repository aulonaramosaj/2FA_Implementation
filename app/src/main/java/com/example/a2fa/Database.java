package com.example.a2fa;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.ContentValues;
import android.database.Cursor;
import android.content.Context;

public class Database extends SQLiteOpenHelper{
    private static final String DB = "database_2fa.db";
    private static final int DB_VERSION = 1;
    private static final String TABLE = "table_users";
    private static final String EMAIL = "user_email";
    private static final String PASSWORD = "user_password";

    public Database(Context context){
        super(context,DB,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String createTableQuery =  "CREATE TABLE " + TABLE +" (" +
                EMAIL + " TEXT PRIMARY KEY, " +
                PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);
        onCreate(db);
    }
    public void insert(String email, String password){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(EMAIL, email);
        values.put(PASSWORD, password);
        db.insert(TABLE, null, values);
        db.close();
    }
    

    public boolean doesUserExist(String email, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM table_users WHERE user_email = ? AND user_password = ?";
        Cursor cursor = db.rawQuery(query, new String[]{email, password});

        if (cursor != null && cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        cursor.close();
        return false;
    }
}