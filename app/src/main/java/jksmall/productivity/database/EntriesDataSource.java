package jksmall.productivity.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class EntriesDataSource {

    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSQLIteDatabase;

    public EntriesDataSource(Context context) { mDatabaseHelper = new DatabaseHelper(context); };

    public void open() { mSQLIteDatabase = mDatabaseHelper.getWritableDatabase(); };

    public void close() { mDatabaseHelper.close(); };



}
