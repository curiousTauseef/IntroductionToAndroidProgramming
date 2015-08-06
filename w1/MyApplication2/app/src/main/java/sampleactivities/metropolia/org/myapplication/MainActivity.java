package sampleactivities.metropolia.org.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

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
    }




}
