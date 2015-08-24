package sampleactivities.metropolia.org.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by WONSEOB on 8/4/2015.
 */
public class Activity3 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout3);
        Button button = (Button) findViewById(R.id. NewButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getBaseContext(), Activity4. class);
                Bundle extras = getIntent().getExtras();
                String stringConveyor = extras.getString("parameter2");
                intent.putExtra("parameter", stringConveyor);
                startActivity(intent);
                finish();
            }
        });
        Bundle extras = getIntent().getExtras();
        String dataParameter = extras.getString("parameter1");
        TextView textData = (TextView) findViewById(R.id. parameterView);
        textData.setText(dataParameter);
        Toast. makeText(this, R.string.started, Toast.LENGTH_SHORT).show();
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
