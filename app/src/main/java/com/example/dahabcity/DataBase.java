package com.example.dahabcity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

class DataBase extends SQLiteOpenHelper {

    // Constants for Database and tables names
    public static int VERSION_NUMBER = 1;
    private static final String DAHAB_DATABASE = "DAHABDATABASE";
    public static final String CAFES_DATABASE = "CAFEDATABASE";
    public static final String RESTAURANTS_DATABASE = "RESTAURANTDATABASE";
    public static final String EVENTS_DATABASE = "EVENTSDATABASE";
    public static final String JOURNEYS_DATABASE = "JOURNEYSDATABASE";

    // class constructor
    public DataBase(@Nullable Context context) {
        super(context, DAHAB_DATABASE, null, VERSION_NUMBER);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // create tables for each category
        db.execSQL("create table if not exists "+CAFES_DATABASE+"(ID Integer primary key autoincrement,title Text,description Text,image Integer,location Text)");
        db.execSQL("create table if not exists "+RESTAURANTS_DATABASE+"(ID Integer primary key autoincrement,title Text,description Text,image Integer,location Text)");
        db.execSQL("create table if not exists "+EVENTS_DATABASE+"(ID Integer primary key autoincrement,title Text,description Text,image Integer,location Text)");
        db.execSQL("create table if not exists "+JOURNEYS_DATABASE+"(ID Integer primary key autoincrement,title Text,description Text,image Integer,location Text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // drop tables
        db.execSQL("DROP TABLE IF EXISTS "+CAFES_DATABASE);
        db.execSQL("DROP TABLE IF EXISTS "+RESTAURANTS_DATABASE);
        db.execSQL("DROP TABLE IF EXISTS "+EVENTS_DATABASE);
        db.execSQL("DROP TABLE IF EXISTS "+JOURNEYS_DATABASE);
        onCreate(db);
    }
    /**
     * Method for delete table elements for release to avoid reinsert same elements before each time the fragment called form the viewPager
     * @param table
     *              to choose which table to release
     */
    public void deleteAll(String table){
        SQLiteDatabase db = this.getReadableDatabase();
        switch (table){
            case CAFES_DATABASE:
                table = CAFES_DATABASE;
                break;
            case RESTAURANTS_DATABASE:
                table = RESTAURANTS_DATABASE;
                break;
            case EVENTS_DATABASE:
                table=EVENTS_DATABASE;
                break;
            case JOURNEYS_DATABASE:
                table=JOURNEYS_DATABASE;
                break;
        }
        db.delete(table,null,null);
    }

    /**
     *insert method to add elements in database
     * @param dataModel
     *            dataModel added in the dataBase
     *@param table
     *            table name to chose which table to take the input
     */
    public boolean insert(DataModel dataModel, String table){
        switch (table){
            case CAFES_DATABASE:
                table = CAFES_DATABASE;
                break;
            case RESTAURANTS_DATABASE:
                table = RESTAURANTS_DATABASE;
                break;
            case EVENTS_DATABASE:
                table=EVENTS_DATABASE;
                break;
            case JOURNEYS_DATABASE:
                table=JOURNEYS_DATABASE;
                break;
        }
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        // create content values
        ContentValues values = new ContentValues();
        values.put("title", dataModel.getTitle());
        values.put("description", dataModel.getDescription());
        values.put("image", dataModel.getImageResourceId());
        values.put("location", dataModel.getLoation());
        sqLiteDatabase.insert(table, null,values);
        return true;

    }
    /**
     *get method to retrieve elements in database
     *@param table
     *            table name to chose which table retrieve from
     */
    public ArrayList<DataModel> get(String table){
        switch (table){
            case CAFES_DATABASE:
                table = CAFES_DATABASE;
                break;
            case RESTAURANTS_DATABASE:
                table = RESTAURANTS_DATABASE;
                break;
            case EVENTS_DATABASE:
                table=EVENTS_DATABASE;
                break;
            case JOURNEYS_DATABASE:
                table=JOURNEYS_DATABASE;
                break;
        }

        String title , description , location;
        int image;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<DataModel> arrayList = new ArrayList<>();

        // perform rawQuery
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM "+table,null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            title = cursor.getString(1);
            description = cursor.getString(2);
            image = cursor.getInt(3);
            location = cursor.getString(4);
            arrayList.add(new DataModel(title,description,image,location));
            cursor.moveToNext();
        }
        return arrayList;
    }

}
