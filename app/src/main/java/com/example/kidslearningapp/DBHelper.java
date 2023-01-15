package com.example.kidslearningapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String QUESTION = "QUESTION";
    public static final String OPTION_A = "OPTION_A";
    public static final String OPTION_B = "OPTION_B";
    public static final String OPTION_C = "OPTION_C";
    public static final String OPTION_SELECTED = "OPTION_SELECTED";
    public static final String RESULT = "RESULT";
    public static final String RESULT_ID = "RESULT_ID";

    public static final String RESULT_TABLE = "RESULT_TABLE";



    public DBHelper(@Nullable Context context) {
        super(context, "resultDB.db", null, 4);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableSTatement = "CREATE TABLE " + RESULT_TABLE + "(" + RESULT_ID +
                " Integer PRIMARY KEY AUTOINCREMENT, " +
                QUESTION + " Text, " + OPTION_A + " Int, " +OPTION_B + " Int, " +OPTION_C + " Int, " +
                OPTION_SELECTED + " Int, " +RESULT + " Int,) ";

        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + RESULT_TABLE);
        onCreate(db);
    }

    public void addQuestionResult(ResultModel ResultModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        //Hash map, as we did in bundles
        ContentValues cv = new ContentValues();

        cv.put( QUESTION, ResultModel.getQuestion());
        cv.put(OPTION_A, ResultModel.getOptiona());
        cv.put(OPTION_B, ResultModel.getOptionb());
        cv.put(OPTION_C, ResultModel.getOptionc());

        cv.put(OPTION_SELECTED, ResultModel.getOptionSelected());
        cv.put(RESULT, ResultModel.getResult());
        db.insert(RESULT_TABLE, null, cv);
        db.close();
    }
}
