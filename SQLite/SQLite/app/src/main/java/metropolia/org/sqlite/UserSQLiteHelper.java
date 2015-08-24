package metropolia.org.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Toni on 05/08/2015.
 */
public class UserSQLiteHelper extends SQLiteOpenHelper {

    String createSQL = "CREATE TABLE user (id INTEGER, name TEXT)";

    public UserSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context,name,factory,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(createSQL);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS user");
        db.execSQL(createSQL);
    }
}
