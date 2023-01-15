package com.example.kidslearningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {
    public static final String QUESTION = "QUESTION";
    public static final String OPTION_A = "OPTION_A";
    public static final String OPTION_B = "OPTION_B";
    public static final String OPTION_C = "OPTION_C";
    public static final String OPTION_SELECTED = "OPTION_SELECTED";
    public static final String RESULT = "RESULT";
    public static final String RESULT_ID = "RESULT_ID";
    public static final String STATUS = "STATUS";

    public static final String RESULT_TABLE = "RESULT_TABLE";



    public DBHelper(@Nullable Context context) {
        super(context, "resultDB.db", null, 4);
        System.out.println("constructor called");

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + RESULT_TABLE + "(" + RESULT_ID +
                " Integer PRIMARY KEY AUTOINCREMENT, " +
                QUESTION + " Text, " + OPTION_A + " Int, " +OPTION_B + " Int, " +OPTION_C + " Int, " +
                OPTION_SELECTED + " Int, " +RESULT + " Int, "+STATUS + " Text) ";

        db.execSQL(createTableSTatement);
        System.out.println("db made successfully");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RESULT_TABLE);
        onCreate(db);
    }

    public void addQuestionResult(ResultModel ResultModel)
    {
        System.out.println("in add");
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put( QUESTION, ResultModel.getQuestion());
        cv.put(OPTION_A, ResultModel.getOptiona());
        cv.put(OPTION_B, ResultModel.getOptionb());
        cv.put(OPTION_C, ResultModel.getOptionc());

        cv.put(OPTION_SELECTED, ResultModel.getOptionSelected());
        cv.put(RESULT, ResultModel.getResult());
        cv.put(STATUS, ResultModel.getStatus());
        db.insert(RESULT_TABLE, null, cv);
        db.close();
    }


    public ArrayList<ResultModel> getAllResults() {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursorCourses = db.rawQuery("SELECT * FROM " + RESULT_TABLE + " order by "+RESULT_ID+" desc limit 10", null);

        ArrayList<ResultModel> resultArrayList = new ArrayList<>();

        // moving our cursor to first position.
        if (cursorCourses.moveToFirst()) {
            do {

                //question, opta, optb, optc, optselected, result
                resultArrayList.add(new ResultModel(cursorCourses.getString(1),
                        cursorCourses.getInt(2),
                        cursorCourses.getInt(3), cursorCourses.getInt(4),
                        cursorCourses.getInt(5), cursorCourses.getInt(6),
                         cursorCourses.getString(7)));
            } while (cursorCourses.moveToNext());

        }

        cursorCourses.close();
        return resultArrayList;
    }


}
