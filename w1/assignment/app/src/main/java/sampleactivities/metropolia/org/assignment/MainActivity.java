package sampleactivities.metropolia.org.assignment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import static android.widget.Toast.makeText;

public class MainActivity extends Activity {

    Button addButton;
    Button searchButton;
    Button showButton;
    Button exitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button)findViewById(R.id.add_movie_button);
        searchButton = (Button)findViewById(R.id.search_button);
        showButton = (Button)findViewById(R.id.show_movie_button);
        exitButton = (Button)findViewById(R.id.exit_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// This is where we define what happens when button is clicked.
                showButtonClickedToastMessage(getResources().getString(R.string.add_movie));
                Intent in = new Intent();
                in.setClass(MainActivity.this, AddMovieActivity.class);
                startActivity(in);
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// This is where we define what happens when button is clicked.
                showButtonClickedToastMessage(getResources().getString(R.string.search_movie));
                Intent in = new Intent();
                in.setClass(MainActivity.this, SearchMovieActivity.class);
                startActivity(in);
            }
        });
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// This is where we define what happens when button is clicked.
                showButtonClickedToastMessage(getResources().getString(R.string.show_movie));
                Intent in = new Intent();
                in.setClass(MainActivity.this, ShowMovieActivity.class);
                startActivity(in);
            }
        });
        exitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
// This is where we define what happens when button is clicked.
                showButtonClickedToastMessage(getResources().getString(R.string.exit));
                finish();
                System.exit(0);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log. d("Activity Life Cycle", "onStop Method called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log. d("Activity Life Cycle", "onDestroy Method called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log. d("Activity Life Cycle", "onPause Method called");
    }

    public void showButtonClickedToastMessage(String buttonName) {
        makeText(this, buttonName + " Clicked", Toast.LENGTH_SHORT).show();
    }


}
