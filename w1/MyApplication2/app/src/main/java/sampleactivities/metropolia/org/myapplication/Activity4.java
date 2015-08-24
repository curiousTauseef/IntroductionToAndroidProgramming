package sampleactivities.metropolia.org.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by WONSEOB on 8/4/2015.
 */
public class Activity4 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout4);
        Bundle extras = getIntent().getExtras();
        String dataParameter = extras.getString("parameter");
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
