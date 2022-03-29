package phong.aprotrain.com.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
CREATE TABLE Note{
        noidung TEXT,
        quantrong INTEGER,
        ngaytao TEXT as
        }
*/


public class DbHelper extends SQLiteOpenHelper {
    public static final String TABLE_NOTE = "Note";
    public static final String DATABASE_NAME = TABLE_NOTE + "DB.db";
    public static final String NOIDUNG = "noidung";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE " + TABLE_NOTE + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, " + NOIDUNG + " TEXT, quantrong BOOL, ngaytao DATETIME)";
    public DbHelper(@Nullable Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_ENTRIES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NOTE);
        onCreate(sqLiteDatabase);

    }
}
