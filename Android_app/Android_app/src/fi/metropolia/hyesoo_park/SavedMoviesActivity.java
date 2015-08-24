package fi.metropolia.hyesoo_park;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class SavedMoviesActivity extends Activity {
	
	ListView mListView;
	ArrayList<Movie> moviesList;
	String name;
	String year;
	String genre;
	String plot;
	String director;
	
	
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.saved_movies_activity);
        mListView = (ListView)findViewById(R.id.listview);
        moviesList = new ArrayList<Movie>();
        }
	
	@Override
	protected void onStart() {
			// TODO Auto-generated method stub
			super.onStart();
			readMovieFromDataBase();
		    showList();
		    
		    mListView.setOnItemClickListener(new OnItemClickListener() {
		    	
				@Override
				public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
					// TODO Auto-generated method stub
					Toast.makeText(getApplicationContext(), moviesList.get(position).getName(), Toast.LENGTH_SHORT).show();
				}
		    	});
		}
	  
	  
	  
	 private void readMovieFromDataBase() {
		 MovieSQLiteHelper msdbh;
		 SQLiteDatabase db;
		 msdbh = new MovieSQLiteHelper(SavedMoviesActivity.this, "DBMovie", null, 1);
		 db = msdbh.getReadableDatabase();
		 Cursor c = db.rawQuery("select * from movies", null);
		 if (c.moveToFirst()) {
		 // List all results
		 do {
			 String name = c.getString(0);
			 String year = c.getString(1);
			 String genre = c.getString(2);
			 String plot = c.getString(3);
			 String director = c.getString(4);
			 Movie movie = new Movie(name, year, genre, plot, director);
			 moviesList.add(movie);
			 
		 Log.d("Database Testing", name + year + genre + plot + director);
		 } while (c.moveToNext());
		 }
		 db.close();
		 
		 
	}
	
	private void showList() {
	ArrayAdapter<Movie> adapter = new MovieArrayAdapter(this,moviesList);
	mListView.setAdapter(adapter);
	}
}
