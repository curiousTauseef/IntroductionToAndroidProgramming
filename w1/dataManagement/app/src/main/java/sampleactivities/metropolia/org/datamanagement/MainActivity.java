package sampleactivities.metropolia.org.datamanagement;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    UserSQLiteHelper usdbh;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        usdbh = new UserSQLiteHelper(this, "DBUser", null, 1);

        Button insert = (Button) findViewById(R.id. insertButton);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We open the database in writer mode
                db = usdbh.getWritableDatabase();
                //Check if the database is opened correctly
                if (db != null)
                {
                    //We will insert 5 new rows
                    for(int i=1; i<=5; i++)
                    {
                        //Generate the data
                        int id = i;
                        String name = "User" + i;
                        //Insert in table User
                        db.execSQL("INSERT INTO user (id, name) " +
                                "VALUES (" + id + ", '" + name
                                +"')");
                        //Create the record using ContentValues
                        //ContentValues newRecord = new ContentValues();
                        //newRecord.put("id", i);
                        //newRecord.put("name", name);
                        //Insert the record in the database
                        //db.insert("user", null, newRecord);
                    }
                    //Close the database
                    db.close();
                }
            }
        });
        Button delete = (Button) findViewById(R.id. deleteButton);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText editText = (EditText) findViewById(R.id.IDField);
                String ID = editText.getText().toString();
                //We open the database in writer mode
                db = usdbh.getWritableDatabase();
                //Check if the database is opened correctly
                if (db != null)
                {
                    db.execSQL("DELETE FROM user WHERE id="+ID+" ");
                    //Close the database
                    db.close();
                }
            }
        });

        Button update = (Button) findViewById(R.id. updateButton);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.newValueField);
                String newValue = editText.getText().toString();
                editText = (EditText) findViewById(R.id.IDField);
                String ID = editText.getText().toString();
                //We open the database in writer mode
                db = usdbh.getWritableDatabase();
                //Check if the database is opened correctly
                if (db != null) {
                    db.execSQL("UPDATE user SET name='"+newValue+"' WHERE id="+ID+" ");
                    //Close the database
                    db.close();
                }
            }
        });

        Button query = (Button) findViewById(R.id. queryButton);
        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = usdbh.getReadableDatabase();
                String[] fields = new String[] {"id", "name"};
                String[] args = new String[] {"User1"};
                Cursor c = db.query("user", fields, "name=?", args, null, null, null);
                //We have to check if exist at least one register
                if (c.moveToFirst()) {
                    //List all results
                    do {
                        String code= c.getString(0);
                        String name = c.getString(1);
                        Log. d("MainActivity", code + name);
                    } while(c.moveToNext());
                }
                db.close();
            }
        });
    }

}
