package app.events;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DatabaseHelper extends SQLiteOpenHelper{
    public static final String Database_Name = "Event";
    public static final String Table_Name = "event";
    public static final String Col1 = "EventName";
    public static final String Col2 = "Location";
    public static final String Col3 ="Date";
    public static final String Col4 = "Time";
    public static final String Col5 = "MoreDetails";
    public DatabaseHelper (Context context) {
        super(context, Database_Name, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL("create table "+Table_Name + ("EventName varchar , Location varchar , Date date , Time time , MoreDetails varchar") );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
     db.execSQL("DROP TABLE IF EXISTS "+Table_Name);
        onCreate(db);
    }
    public boolean insertData(String name,String loc,String date,String time,String more)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(Col1,name);
        contentValues.put(Col2,loc);
        contentValues.put(Col3,date);
        contentValues.put(Col4,time);
        contentValues.put(Col5,more);
       long res = db.insert(Table_Name,null,contentValues);
        if(res == -1)
            return  false;
        else
            return true;

    }
    public Cursor getAllRecords ()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor result = db.rawQuery("select * from "+Table_Name,null);
        return result;
    }
}
