package com.shourov.mycgpa.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shourov.mycgpa.ModelClass.Model_class;
import java.util.ArrayList;

public class DatabaseSource {

    DataBaseHelper dataBaseHelper;
    SQLiteDatabase sqLiteDatabase;

    public DatabaseSource(Context context){

        dataBaseHelper=new DataBaseHelper(context);

    }

    public void open(){

        sqLiteDatabase=dataBaseHelper.getWritableDatabase();

    }

  /*  public void close(){

        dataBaseHelper.close();

    }  */

    public boolean addCourse(Model_class model){

        this.open();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.COL_NAME,model.getCourse_name());
        contentValues.put(DataBaseHelper.COL_GRADE,model.getGrade());
        contentValues.put(DataBaseHelper.COL_CREDIT,model.getCredit());
        contentValues.put(DataBaseHelper.COL_SEMESTER,model.getSemester());
        contentValues.put(DataBaseHelper.COL_REMARKS,model.getCourse_remarks());

        Long insertRow=sqLiteDatabase.insert(DataBaseHelper.COURSE_TABLE,null,contentValues);

      //  this.close();

        if(insertRow>0){
            return true;

        }

        else return false;
    }

     public boolean updateCourse(Model_class model){

        this.open();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DataBaseHelper.COL_NAME,model.getCourse_name());
        contentValues.put(DataBaseHelper.COL_GRADE,model.getGrade());
        contentValues.put(DataBaseHelper.COL_CREDIT,model.getCredit());
        contentValues.put(DataBaseHelper.COL_SEMESTER,model.getSemester());
        contentValues.put(DataBaseHelper.COL_REMARKS,model.getCourse_remarks());

                    int updatedRow  =   sqLiteDatabase.update(DataBaseHelper.COURSE_TABLE,contentValues,DataBaseHelper.COL_ID+" =?",new String[]{String.valueOf(model.getId())});


                    if(updatedRow>0)
                        return true;

                    else return false;

    }

     public ArrayList<Model_class> getAllCourse(String order){

        //dataBaseHelper.getReadableDatabase();

        this.open();
        
        ArrayList<Model_class> arrayList=new ArrayList<>();

                        Cursor cursor = sqLiteDatabase.query(dataBaseHelper.COURSE_TABLE, null, null, null, null, null,order,null);

                        if(cursor.moveToFirst()){

                            do{

                              String name=  cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_NAME));
                               int semester= cursor.getInt(cursor.getColumnIndex(dataBaseHelper.COL_SEMESTER));
                               String remarks= cursor.getString(cursor.getColumnIndex(dataBaseHelper.COL_REMARKS));
                                int id= cursor.getInt(cursor.getColumnIndex(dataBaseHelper.COL_ID));
                                float grade=  cursor.getFloat(cursor.getColumnIndex(dataBaseHelper.COL_GRADE));
                                float credit=  cursor.getFloat(cursor.getColumnIndex(dataBaseHelper.COL_CREDIT));
                                Model_class model = new Model_class(name,remarks,semester,id,credit,grade);
                                arrayList.add(model);

                            }
                            while (cursor.moveToNext());

                        }

      //  this.close();
        cursor.close();
        return arrayList;

    }

    public boolean deleteCourse(Model_class model){

        this.open();
        int deleteRow =  sqLiteDatabase.delete(DataBaseHelper.COURSE_TABLE,DataBaseHelper.COL_ID+" =?",new String[]{String.valueOf(model.getId())});
     //   this.close();

      if(deleteRow>0){

          return true;

      }
      else return false;
    }

    public int getLastRow(){

        //dataBaseHelper.getReadableDatabase();
        this.open();

        Cursor cursor = sqLiteDatabase.query(dataBaseHelper.COURSE_TABLE, new String[] {dataBaseHelper.COL_ID}, null, null, null, null,null,null);
        cursor.moveToLast();

        int o=cursor.getInt(cursor.getColumnIndex(dataBaseHelper.COL_ID));

      //  this.close();
        cursor.close();
        return o;

    }

}
