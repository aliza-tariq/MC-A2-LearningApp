package com.example.kidslearningapp;

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



    public DBHelper(@Nullable Context context,
                    @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context, @Nullable String name,
                    @Nullable SQLiteDatabase.CursorFactory factory, int version,
                    @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DBHelper(@Nullable Context context,
                    @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTableSTatement = "CREATE TABLE " + RESULT_TABLE + "(" + RESULT_ID +
                " Integer PRIMARY KEY AUTOINCREMENT, " +
                QUESTION + " Text, " + OPTION_A + " Int, " +OPTION_B + " Int, " +OPTION_C + " Int, " +
                OPTION_SELECTED + " Int, " +RESULT + " Int,) ";

        db.execSQL(createTableSTatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
