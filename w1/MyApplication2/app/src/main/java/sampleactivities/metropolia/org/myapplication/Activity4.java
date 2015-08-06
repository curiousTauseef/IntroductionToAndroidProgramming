package sampleactivities.metropolia.org.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

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
    }
}
