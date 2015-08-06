package sampleactivities.metropolia.org.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    }

}
