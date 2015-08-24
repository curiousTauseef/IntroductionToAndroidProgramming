package fi.metropolia.hyesoo_park;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button addButton;
	Button searchButton;
	Button savedButton;
	Button exitButton;
		
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addButton = (Button)findViewById(R.id.add_movie_button);
        searchButton = (Button)findViewById(R.id.search_button);
        savedButton = (Button)findViewById(R.id.saved_button);
        exitButton = (Button)findViewById(R.id.exit_button);
    }

   @Override
protected void onStart() {
	// TODO Auto-generated method stub
	super.onStart();
	Log.d("Activity Life Cycle", "onStart Method called");
	addButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent in = new Intent();
			in.setClass(MainActivity.this, SecondMovieActivity.class);
			startActivity(in);
			finish();
			showButtonClickedToastMessage(getResources().getString(R.string.addmovie));
		}
	});
	
  searchButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent in = new Intent();
			in.setClass(MainActivity.this, search_movies.class);
			startActivity(in);
			finish();
		}
	});
  
  
  savedButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent in = new Intent();
			in.setClass(MainActivity.this,SavedMoviesActivity.class);
			startActivity(in);
			finish();
			
		}
	});
  
  
  exitButton.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
			System.exit(0);
			
		}
	});
	}
   
   public void showButtonClickedToastMessage(String buttonName) {
	   Toast.makeText(this, buttonName + " Clicked", Toast.LENGTH_SHORT).show();
	   }
     
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
