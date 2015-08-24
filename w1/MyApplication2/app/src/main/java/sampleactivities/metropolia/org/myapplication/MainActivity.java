package sampleactivities.metropolia.org.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        Log. d("MainActivity", "onCreate");

        Button button = (Button) findViewById(R.id. activity2button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity2.class);
                //Sending a parameter to the second activity
                String aux = "String created in MainActivity";
                intent.putExtra("parameter", aux);
                startActivity(intent);
            }
        });

        Button button2 = (Button) findViewById(R.id. activity3button);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity3. class);
                EditText editText1 = (EditText) findViewById(R.id.editText1);
                String text1 = editText1.getText().toString();
                intent.putExtra("parameter1", text1);
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                String text2 = editText2.getText().toString();
                intent.putExtra("parameter2", text2);
                startActivity(intent);
            }
        });



        Button button3 = (Button) findViewById(R.id. activity4button);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity4.class);
                EditText editText = (EditText) findViewById(R.id.editText2);
                String text = editText.getText().toString();
                intent.putExtra("parameter", text);
                startActivity(intent);
            }
        });

        Button button4 = (Button) findViewById(R.id. activityDBbutton);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), ActivityDB.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onRestart()
    {
        super.onRestart();
        Log. d("MainActivity", "onRestart");
    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log. d("MainActivity", "onStart");
    }
    @Override
    public void onResume()
    {
        super.onResume();
        Log. d("MainActivity", "onResume");
    }
    @Override
    public void onPause()
    {
        super.onPause();
        Log. d("MainActivity", "onPause");
    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log. d("MainActivity", "onStop");
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log. d("MainActivity", "onDestroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int option = item.getItemId();
        switch (option)
        {
            case R.id. option1:
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity2. class);
                //Sending a parameter to the second activity
                String aux = "String created in MainActivity";
                intent.putExtra("parameter", aux);
                startActivity(intent);
                break;
            case R.id. option2:
                Toast. makeText(this, R.string.click2, Toast.LENGTH_SHORT).show();
                showDialog();
                break;
        }
        return false;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent. KEYCODE_BACK)) {
            Toast. makeText(this,R.string. backPressed,Toast. LENGTH_SHORT).show();
            showDialog();

        }
        return false;
    }

    private void showDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(R.string.titleDialog);
        alert.setMessage(R.string.messageDialog);
        alert.setPositiveButton(R.string.ok, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        finish();
                    }
                });
        alert.setNegativeButton(R.string.cancel, new
                DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });
        alert.show();
    }
}
