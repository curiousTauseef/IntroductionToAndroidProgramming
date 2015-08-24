package sampleactivities.metropolia.org.datamanagement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by WONSEOB on 8/9/2015.
 */
public class UserSQLiteHelper extends SQLiteOpenHelper {

    String createSQL = "CREATE TABLE user (id INTEGER, name TEXT)";

    public UserSQLiteHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createSQL = "CREATE TABLE user (id INTEGER, name TEXT)";
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL(createSQL);
    }
}
