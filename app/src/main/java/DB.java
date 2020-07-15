import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {
    public static final String Db_Name="Student_Info";

    public DB(@Nullable Context context) {
        super(context, Db_Name, null, 1);
    }



    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String table="create table information1(id integer primary key autoincrement, name text,detail text,date text)";
        sqLiteDatabase.execSQL(table);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists information1");
        onCreate(sqLiteDatabase);
    }
    public boolean addRecord(String s1,String s2,String s3,String s4,byte [] newImg){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues c= new ContentValues();
        c.put("name",s1);
        c.put("detail",s2);
        c.put("date",s3);
        long result=sqLiteDatabase.insert("information1",null,c);
        if(result==0)
        {return false;}
        else
        {
            return true;
        }
    }
    public Cursor readData(){
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor c=db.rawQuery("select * from information1 ",null);
        return c;
    }
}