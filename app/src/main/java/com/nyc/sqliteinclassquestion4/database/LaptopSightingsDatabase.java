package com.nyc.sqliteinclassquestion4.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.nyc.sqliteinclassquestion4.models.Sightings;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Wayne Kellman on 1/14/18.
 */

public class LaptopSightingsDatabase extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "laptopSightings.db";
    private static final String TABLE_NAME = "laptopSightings";
    private static final int SCHEMA_VERSION = 1;

    public LaptopSightingsDatabase(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE " + TABLE_NAME +
                        " (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "name TEXT,time_stamp DATETIME DEFAULT CURRENT_TIMESTAMP);");
    }

    public void addSighting(String name) {

        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE name = '" + name + "';"
                , null);
        if (cursor.getCount() == 0) {
            getWritableDatabase().execSQL("INSERT INTO " + TABLE_NAME +
                    " (name) VALUES('" + name + "');");
        }
        cursor.close();

    }

    public List<Sightings> getSightings() {

        List<Sightings> sightingsList = new ArrayList<>();
        Cursor cursor = getReadableDatabase().rawQuery("SELECT * FROM " + TABLE_NAME + ";", null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Sightings sightings = new Sightings(
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("time_stamp")));
                    sightingsList.add(sightings);
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return sightingsList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
