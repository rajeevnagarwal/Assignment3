package com.example.rajeevnagarwal.assignment3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Rajeev Nagarwal on 10/1/2016.
 */
/* DatabaseHandler to communicated with Sqlite Database*/
public class DatabaseHandler extends SQLiteOpenHelper {
    private static final String TEXT_TYPE =   "TEXT";
    private static final String COMMA_SEP = ", ";
    private static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + Person.PersonEntry.TABLE_NAME+"("+
            Person.PersonEntry._ID+" INTEGER PRIMARY KEY,"+Person.PersonEntry.COLUMN_FIRSTNAME+" "+TEXT_TYPE+COMMA_SEP+
            Person.PersonEntry.COLUMN_LASTNAME+" "+TEXT_TYPE+")";
    private static final String SQL_DELETE_ENTRIES="DROP TABLE IF EXISTS "+ Person.PersonEntry.TABLE_NAME;
    public static final int  DATABASE_VERSION = 3;
    public static final String DATABASE_NAME="PersonEntry.db";
    public DatabaseHandler(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {
        onUpgrade(db,oldVersion,newVersion);
    }
    // For creating a record
    public void addPerson(String first,String last)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Person.PersonEntry.COLUMN_FIRSTNAME,first);
        values.put(Person.PersonEntry.COLUMN_LASTNAME,last);
        db.insert(Person.PersonEntry.TABLE_NAME,null,values);
        db.close();
    }
    // For printing all records
    public String print()
    {
        String query = "SELECT * from "  + Person.PersonEntry.TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        String result="";
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do {
                result = result + (cursor.getString(0))+". ";
                result = result + (cursor.getString(1))+", ";
                result = result + (cursor.getString(2))+"\n";
            }while(cursor.moveToNext());

        }
        return result;
    }
    // For updating a record
    public void updatePerson(int id,String first,String last)
    {
        SQLiteDatabase db  = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Person.PersonEntry.COLUMN_FIRSTNAME,first);
        values.put(Person.PersonEntry.COLUMN_LASTNAME,last);
        db.update(Person.PersonEntry.TABLE_NAME,values, Person.PersonEntry._ID + " = ?",new String[]{String.valueOf(id)});
    }
    // For deleting a record
    public void deletePerson(int id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Person.PersonEntry.TABLE_NAME, Person.PersonEntry._ID + " =?",new String[]{String.valueOf(id)});

    }








}
