package com.shourov.mycgpa.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shourov.mycgpa.ModelClass.Schedule_Model;
import java.util.ArrayList;

public class DatabaseSource_Schedule {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase sqLiteDatabase;

    public DatabaseSource_Schedule(Context context){

        dataBaseHelper=new DataBaseHelper(context);

    }

    public void open(){

        sqLiteDatabase=dataBaseHelper.getWritableDatabase();

    }

 /*   public void close(){

        dataBaseHelper.close();

    } */

    public boolean addSchedule(Schedule_Model model){

        this.open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.COL_TITLE,model.getTitle());
        contentValues.put(DataBaseHelper.COL_DES,model.getDes());
        contentValues.put(DataBaseHelper.COL_DATE,model.getDate());
        contentValues.put(DataBaseHelper.COL_IS_NOTIFICATION,model.getIs_notification());
        contentValues.put(DataBaseHelper.COL_IMAGE,model.getImageUri());
        contentValues.put(DataBaseHelper.COL_BEFORE_DAY,model.getBefore_day());
        contentValues.put(DataBaseHelper.COL_MILI,model.getMili_sort());

        Long insertRow=sqLiteDatabase.insert(DataBaseHelper.COURSE_TABLE1,null,contentValues);

    //    this.close();

        if(insertRow>0){
            return true;
        }
        else return false;
    }

    public boolean updateSchedule(Schedule_Model model){

        this.open();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DataBaseHelper.COL_TITLE,model.getTitle());
        contentValues.put(DataBaseHelper.COL_DES,model.getDes());
        contentValues.put(DataBaseHelper.COL_DATE,model.getDate());
        contentValues.put(DataBaseHelper.COL_IS_NOTIFICATION,model.getIs_notification());
        contentValues.put(DataBaseHelper.COL_IMAGE,model.getImageUri());
        contentValues.put(DataBaseHelper.COL_BEFORE_DAY,model.getBefore_day());
        contentValues.put(DataBaseHelper.COL_MILI,model.getMili_sort());

        int updatedRow  =   sqLiteDatabase.update(DataBaseHelper.COURSE_TABLE1,contentValues,DataBaseHelper.COL_ID1+" =?",new String[]{String.valueOf(model.getId())});

        if(updatedRow>0)
            return true;

        else return false;

    }

    public ArrayList<Schedule_Model> getAllSchedule(){

        //dataBaseHelper.getReadableDatabase();

        this.open();

        final ArrayList<Schedule_Model> arrayList=new ArrayList<>();

        Cursor cursor = sqLiteDatabase.query(dataBaseHelper.COURSE_TABLE1, null, null, null, null, null,DataBaseHelper.COL_MILI + " ASC",null);

        if(cursor.moveToFirst()){

            do{

                final String title=  cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_TITLE));
                final String  des= cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_DES));
                final String date= cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_DATE));
                final int id= cursor.getInt(cursor.getColumnIndex(dataBaseHelper.COL_ID1));
                final String is_notification=  cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_IS_NOTIFICATION));
                final String image_uri=  cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_IMAGE));
                final String before_spin=  cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_BEFORE_DAY));
                final String miliSort=  cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_MILI));


                        Schedule_Model model = new Schedule_Model(title,des,date,is_notification,image_uri,id,before_spin,miliSort);
                        arrayList.add(model);


            }
            while (cursor.moveToNext());

        }

      //  this.close();
        cursor.close();
        return arrayList;

    }

    public boolean deleteSchedule(Schedule_Model model){

        this.open();
        int deleteRow =  sqLiteDatabase.delete(DataBaseHelper.COURSE_TABLE1,DataBaseHelper.COL_ID1+" =?",new String[]{String.valueOf(model.getId())});

    //    this.close();

        if(deleteRow>0){

            return true;

        }else return false;


    }

    public int getLastRow1(){

        //dataBaseHelper.getReadableDatabase();

        this.open();

        Cursor cursor = sqLiteDatabase.query(dataBaseHelper.COURSE_TABLE1, new String[] {dataBaseHelper.COL_ID1}, null, null, null, null,null,null);
        cursor.moveToLast();

        int o1=cursor.getInt(cursor.getColumnIndex(dataBaseHelper.COL_ID1));

       // this.close();
        cursor.close();
        return o1;

    }

}
