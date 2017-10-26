package jksmall.productivity.database;

import android.provider.BaseColumns;

public final class DatabaseContract {

    private DatabaseContract() {}

    public static class DatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "entry";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_NOTES = "notes";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_MON = "mon";
        public static final String COLUMN_NAME_TUE = "tue";
        public static final String COLUMN_NAME_WED = "wed";
        public static final String COLUMN_NAME_THU = "thu";
        public static final String COLUMN_NAME_FRI = "fri";
        public static final String COLUMN_NAME_SAT = "sat";
        public static final String COLUMN_NAME_SUN = "sun";
        public static final String COLUMN_NAME_LOCK = "lock";

        public String title;
        public String notes;
        public String time;
        public int mon;
        public int tue;
        public int wed;
        public int thu;
        public int fri;
        public int sat;
        public int sun;
        public int lock;
    }

    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DatabaseEntry.TABLE_NAME + " (" +
                    DatabaseEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    DatabaseEntry.COLUMN_NAME_TITLE + " TEXT," +
                    DatabaseEntry.COLUMN_NAME_NOTES + " TEXT," +
                    DatabaseEntry.COLUMN_NAME_TIME + " TEXT," +
                    DatabaseEntry.COLUMN_NAME_MON + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_TUE + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_WED + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_THU + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_FRI + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_SAT + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_SUN + " INTEGER," +
                    DatabaseEntry.COLUMN_NAME_LOCK + " INTEGER)";

    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DatabaseEntry.TABLE_NAME;

}


