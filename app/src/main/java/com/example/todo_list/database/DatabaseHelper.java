package com.example.todo_list.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import com.example.todo_list.MainActivity;
import com.example.todo_list.data_types.Data_Programming;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database_name";

    private static final String TABLE_NAME = "table_main";
    private static final String PROGRAMMING = "table_programming";
    private static final String HOME = "table_home";
    private static final String SCHOOL = "table_school";
    private static final String SHOPPING = "table_shopping";

    public static final String TYPE = "TYPE";
    public static final String ID = "ID";
    public static final String TASK = "TASK";
    public static final String TOPIC = "TOPIC";
    public static final String DEADLINE1 = "DEADLINE1";
    public static final String DEADLINE2 = "DEADLINE2";
    public static final String DEADLINE3 = "DEADLINE3";
    public static final String DEADLINE4 = "DEADLINE4";
    public static final String DEADLINE5 = "DEADLINE5";
    public static final String CREATIONTIME1 = "CREATIONTIME1";
    public static final String CREATIONTIME2 = "CREATIONTIME2";
    public static final String CREATIONTIME3 = "CREATIONTIME3";
    public static final String CREATIONTIME4 = "CREATIONTIME4";
    public static final String CREATIONTIME5 = "CREATIONTIME5";
    public static final String TODAY = "TODAY";
    public static final String CHECKED = "CHECKED";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        //context.deleteDatabase(DATABASE_NAME); //Delete Database when starting
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "create table " + TABLE_NAME + " (" + ID + " INTEGER PRIMARY KEY, " + TYPE + " TEXT, " + TASK + " TEXT, " +
                DEADLINE1 + " INTEGER, " + DEADLINE2 + " INTEGER, " + DEADLINE3 + " INTEGER, " + DEADLINE4 + " INTEGER, " + DEADLINE5 + " INTEGER, " +
                CREATIONTIME1 + " INTEGER, " + CREATIONTIME2 + " INTEGER, " + CREATIONTIME3 + " INTEGER, " + CREATIONTIME4 + " INTEGER, " + CREATIONTIME5 + " INTEGER, " +
                TODAY + " INTEGER, " + CHECKED + " INTEGER," + TOPIC + " TEXT)";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        onCreate(db);
    }
    public boolean addData(String type, int id, String task, List<Integer> deadline, List<Integer> creation, boolean today, boolean checked, String projekt_name){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TYPE,type);
        contentValues.put(ID,id);
        contentValues.put(TASK,task);
        contentValues.put(DEADLINE1,deadline.get(0));
        contentValues.put(DEADLINE2,deadline.get(1));
        contentValues.put(DEADLINE3,deadline.get(2));
        contentValues.put(DEADLINE4,deadline.get(3));
        contentValues.put(DEADLINE5,deadline.get(4));
        contentValues.put(CREATIONTIME1,creation.get(0));
        contentValues.put(CREATIONTIME2,creation.get(1));
        contentValues.put(CREATIONTIME3,creation.get(2));
        contentValues.put(CREATIONTIME4,creation.get(3));
        contentValues.put(CREATIONTIME5,creation.get(4));
        contentValues.put(TOPIC,projekt_name);

        //Save Boolean as Int (0 = False & 1 = True)
        int today_int = 0;
        if (today){ today_int = 1; }

        int checked_int = 0;
        if (checked){ checked_int = 1; }

        contentValues.put(TODAY,today_int);
        contentValues.put(CHECKED,checked_int);

        long insert = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (insert == -1){
            return false;
        }else {
            return true;
        }
    }
    public List<Data_Programming> getData_Programming(){
        List<Data_Programming> return_Data = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.rawQuery("select * from "+TABLE_NAME,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Log.d("DEBUG","Start");
            List<Integer> deadline = new ArrayList<>();
            deadline.add(cursor.getInt(3));
            deadline.add(cursor.getInt(4));
            deadline.add(cursor.getInt(5));
            deadline.add(cursor.getInt(6));
            deadline.add(cursor.getInt(7));
            Log.d("DEBUG","Mid");

            List<Integer> creaton = new ArrayList<>();
            creaton.add(cursor.getInt(8));
            creaton.add(cursor.getInt(9));
            creaton.add(cursor.getInt(10));
            creaton.add(cursor.getInt(11));
            creaton.add(cursor.getInt(12));
            Log.d("DEBUG","End");

            //Read Int as Boolean
            boolean today = false;
            if (cursor.getInt(13) == 1){
                today = true;
            }

            boolean checked = false;
            if (cursor.getInt(14) == 1){
                checked = true;
            }


            return_Data.add(new Data_Programming(cursor.getString(1),cursor.getInt(0),cursor.getString(2),deadline,creaton,today,checked,cursor.getString(15)));
            cursor.moveToNext();
        }
        cursor.close();
        sqLiteDatabase.close();
        return return_Data;
    }

    //Del function
    public boolean delItem(Data_Programming del_data){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = " + del_data.getId();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            return true;
        }else {
            return false;
        }
    }
}