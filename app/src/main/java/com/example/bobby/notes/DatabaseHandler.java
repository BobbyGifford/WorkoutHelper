package com.example.bobby.notes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bobby on 7/19/17.
 */

public class DatabaseHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "exercises.db";
    public static final String TABLE_EXERCISES = "exercises";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_EXERCISES_CATEGORY = "exercisesCategory";
    public static final String COLUMN_EXERCISES_NAME = "exercisesName";
    public static final String COLUMN_EXERCISES_DESC = "exercisesDesc";


    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "CREATE TABLE " + TABLE_EXERCISES + "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_EXERCISES_CATEGORY + " INTEGER, " +
                COLUMN_EXERCISES_NAME + " TEXT, " +
                COLUMN_EXERCISES_DESC + " TEXT" +
                ");";
        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_EXERCISES);
        onCreate(sqLiteDatabase);
    }

    public void addExercise(int exerciseCategory, String exerciseName, String exerciseDesc){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXERCISES_CATEGORY, exerciseCategory);
        values.put(COLUMN_EXERCISES_NAME, exerciseName);
        values.put(COLUMN_EXERCISES_DESC, exerciseDesc);
        sqLiteDatabase.insert(TABLE_EXERCISES, null, values);
        sqLiteDatabase.close();
    }

    public void deleteExerciseByName(String exerciseName){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_EXERCISES + " WHERE " +
                COLUMN_EXERCISES_NAME + "='"+exerciseName+"'");

        sqLiteDatabase.close();
    }

    public void updateByName(String currentName, String name, String desc){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_EXERCISES_NAME, name);
        values.put(COLUMN_EXERCISES_DESC, desc);

        String where = COLUMN_EXERCISES_NAME + " == ?";

        String[] whereArgs = new String [] { currentName };

        sqLiteDatabase.update(TABLE_EXERCISES, values, where, whereArgs);
        sqLiteDatabase.close();
    }

    public void getExercises(){
        for(int i =0; i<DefaultList.getDefaultList().size(); i++) {

            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            String query = "SELECT * FROM " + TABLE_EXERCISES + " WHERE " +
                    COLUMN_EXERCISES_CATEGORY.toString() + " == " + Integer.toString(i);
            Cursor c = sqLiteDatabase.rawQuery(query, null);

            c.moveToFirst();

            while (!c.isAfterLast()) {
                Exercises newExercise = new Exercises(
                        c.getString(c.getColumnIndex(COLUMN_EXERCISES_NAME)),
                        c.getString(c.getColumnIndex(COLUMN_EXERCISES_DESC)),
                        true);

                c.moveToNext();
                DefaultList.getDefaultList().get(i).getTestList().add(newExercise);
            }
            sqLiteDatabase.close();
        }
    }
}
