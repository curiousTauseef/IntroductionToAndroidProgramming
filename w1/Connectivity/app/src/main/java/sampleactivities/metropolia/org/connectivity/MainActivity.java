package sampleactivities.metropolia.org.connectivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText place;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        place = (EditText)findViewById(R.id. editText1);

        Button button = (Button)findViewById(R.id. button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                double[] coordinates=search(place.getText().toString());
            }
        });

    }
    public double[] search(String place)
    {
        double[] coordinates = new double[2];
        String stringHTTP1 =
                "http://maps.googleapis.com/maps/api/geocode/json?address=";
        String stringHTTP2 = "&sensor=false";
        String stringHTTP = stringHTTP1 + place + stringHTTP2;
        stringHTTP = deleteBlanks(stringHTTP);
        return coordinates;
    }

    public String deleteBlanks(String stringHTTP)
    {
        //Replace the blanks in the URL
        return stringHTTP.replace(" ", "%20");
    }
}
