package jksmall.productivity.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import static jksmall.productivity.database.DatabaseContract.DatabaseEntry.TABLE_NAME;
import static jksmall.productivity.database.DatabaseContract.SQL_CREATE_ENTRIES;
import static jksmall.productivity.database.DatabaseContract.SQL_DELETE_ENTRIES;
import static jksmall.productivity.database.DatabaseContract.DatabaseEntry;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Entries.db";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public void addEntry(DatabaseEntry databaseEntry){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DatabaseEntry.COLUMN_NAME_TITLE, databaseEntry.title);
        values.put(DatabaseEntry.COLUMN_NAME_NOTES, databaseEntry.notes);
        values.put(DatabaseEntry.COLUMN_NAME_TIME, databaseEntry.time);
        values.put(DatabaseEntry.COLUMN_NAME_MON, databaseEntry.mon);
        values.put(DatabaseEntry.COLUMN_NAME_TUE, databaseEntry.tue);
        values.put(DatabaseEntry.COLUMN_NAME_WED, databaseEntry.wed);
        values.put(DatabaseEntry.COLUMN_NAME_THU, databaseEntry.thu);
        values.put(DatabaseEntry.COLUMN_NAME_FRI, databaseEntry.fri);
        values.put(DatabaseEntry.COLUMN_NAME_SAT, databaseEntry.sat);
        values.put(DatabaseEntry.COLUMN_NAME_SUN, databaseEntry.sun);
        values.put(DatabaseEntry.COLUMN_NAME_LOCK, databaseEntry.lock);

        db.insert(TABLE_NAME, null, values);
        db.close();
    };

    public ArrayList<HashMap<String, String>> getEntries() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery =  "SELECT * FROM " + DatabaseEntry.TABLE_NAME;

        ArrayList<HashMap<String, String>> entryList = new ArrayList<HashMap<String, String>>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String, String> entry = new HashMap<String, String>();
                entry.put("title", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_TITLE)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_NOTES)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_TIME)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_MON)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_TUE)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_WED)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_THU)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_FRI)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_SAT)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_SUN)));
                entry.put("notes", cursor.getString(cursor.getColumnIndex(DatabaseEntry.COLUMN_NAME_LOCK)));
                entryList.add(entry);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return entryList;

    }

};