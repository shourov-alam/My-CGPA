package com.shourov.mycgpa.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="course.db";
    public static final int DATABASE_VERSION= 7;
    public static final String COURSE_TABLE="course_table";
    public static final String COL_ID= "_id";
    public static final String COL_NAME= "course_name";
    public static final String COL_REMARKS= "course_remarks";
    public static final String COL_CREDIT= "credit";
    public static final String COL_GRADE= "grade";
    public static final String COL_SEMESTER= "semester";
    public static final String CREATE_TABLE = "create table "+COURSE_TABLE+ "("

            +COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_NAME+ " TEXT, "
            +COL_GRADE+" FLOAT, "
            +COL_CREDIT+ " FLOAT, "
            +COL_SEMESTER+ " INTEGER,"
            +COL_REMARKS+ " TEXT  "
            +")";

    public static final String COURSE_TABLE1="schedule_table";
    public static final String COL_ID1= "_id";
    public static final String COL_TITLE= "schedule_title";
    public static final String COL_DES= "schedule_des";
    public static final String COL_DATE= "date_time";
    public static final String COL_IS_NOTIFICATION= "is_notification";
    public static final String COL_BEFORE_DAY= "before_day";
    public static final String COL_IMAGE= "image_uri";
    public static final String COL_MILI= "mili_sort";
    public static final String CREATE_TABLE1 = "create table "+COURSE_TABLE1+ "("

            +COL_ID1+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +COL_TITLE+ " TEXT, "
            +COL_DES+" TEXT, "
            +COL_DATE+ " TEXT, "
            +COL_IS_NOTIFICATION+ " TEXT,"
            +COL_BEFORE_DAY+ " TEXT,"
            +COL_MILI+ " TEXT,"
            +COL_IMAGE+ " TEXT  "

            +")";


    public DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        db.execSQL(CREATE_TABLE1);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL(" drop table if exists "+ COURSE_TABLE);
        db.execSQL(" drop table if exists "+ COURSE_TABLE1);
        this.onCreate(db);

    }
}
