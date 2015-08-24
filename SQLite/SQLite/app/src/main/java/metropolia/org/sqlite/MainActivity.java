package metropolia.org.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    UserSQLiteHelper usdbh;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usdbh = new UserSQLiteHelper(MainActivity.this, "DBUser", null, 2);


        Button button = (Button) findViewById(R.id.insertbtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = usdbh.getWritableDatabase();

                if (db != null)
                {
                    for (int i=1; i<=5; i++)
                    {
                        int id=i;
                        String name = "User"+i;

                        ContentValues newRecord = new ContentValues();
                        newRecord.put("id", i);
                        newRecord.put("name", name);
                        db.insert("user", null, newRecord);
                    }

                    db.close();
                }
            }
        });

        Button button2 = (Button) findViewById(R.id.querybtn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = usdbh.getReadableDatabase();

                String[] fields = new String[]{"id","name"};
                String[] args = new String[]{"User1"};

                Cursor c = db.query("user", fields, null, null, null, null, null);

                if (c.moveToFirst())
                {
                    do {
                        String code = c.getString(0);
                        String name = c.getString(1);

                        Log.d("MainActivity", code+name);

                    } while (c.moveToNext());
                }

                db.close();
            }
        });
    }
}
