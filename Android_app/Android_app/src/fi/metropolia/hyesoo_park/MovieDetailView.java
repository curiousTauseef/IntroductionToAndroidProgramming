package fi.metropolia.hyesoo_park;

import android.app.Activity;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;
import android.view.View;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MovieDetailView extends Activity {

	TextView mNameTV;
	TextView mYearTV;
	TextView mGenreTV;
	TextView mPlotTV;
	TextView mDirectorTV;
	String mName, mYear, mGenre, mPlot, mDirector;
	Button saveButton;

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.moviedetailview);
		mNameTV = (TextView) findViewById(R.id.tv_movie_name);
		mYearTV = (TextView) findViewById(R.id.tv_year_released);
		mGenreTV = (TextView) findViewById(R.id.tv_genre);
		mPlotTV = (TextView) findViewById(R.id.tv_plot);
		mDirectorTV = (TextView) findViewById(R.id.tv_director);
		saveButton = (Button) findViewById(R.id.saveButton);
	}

	@Override
	protected void onStart() {
		super.onStart();
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		if (extras != null) {
			mName = extras.getString("mName");
			mYear = extras.getString("mYear");
			mGenre = extras.getString("mGenre");
			mPlot = extras.getString("mPlot");
			mDirector = extras.getString("mDirector");
			mNameTV.setText(mName);
			mYearTV.setText(mYear);
			mGenreTV.setText(mGenre);
			mPlotTV.setText(mPlot);
			mDirectorTV.setText(mDirector);
			
		} else {
			mNameTV.setText("Extras was null");
			mYearTV.setText("Extras was null");
			mGenreTV.setText("Extras was null");
			mPlotTV.setText("Extras was null");
			mDirectorTV.setText("Extras was null");
		}

		/*mNameTV.setText(getIntent().getExtras().getString("mName"));
		mYearTV.setText(getIntent().getExtras().getString("mYear"));
		mGenreTV.setText(getIntent().getExtras().getString("mGenre"));
		mPlotTV.setText(getIntent().getExtras().getString("mPlot"));
		mDirectorTV.setText(getIntent().getExtras().getString("mDirector"));*/

		Log.d("Activity Life Cycle", "onStart Method called");

		saveButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (isDataValidated()) {
					saveMovieToDataBase();
				} else {
					// Do something
					// showErrorMessage();
				}
			}
		});

	}

	protected void showErrorMessage() {
		// TODO Auto-generated method stub

	}

	protected void saveMovieToDataBase() {
		MovieSQLiteHelper msdbh; SQLiteDatabase db;
		msdbh = new MovieSQLiteHelper(MovieDetailView.this, "DBMovie", null, 1);
		// We open the database in writer mode 
		
		db = msdbh.getWritableDatabase();
		
		// Create the record using ContentValues
		ContentValues newRecord = new ContentValues();
		newRecord.put("name", mName);
		newRecord.put("year", mYear);
		newRecord.put("genre", mGenre);
		newRecord.put("plot", mPlot);
		newRecord.put("director", mDirector);
		// Insert the record in the database
		db.insert("movies", null, newRecord); 
		db.close();
		
	}

	protected boolean isDataValidated() {
		/*
		 * if all three fields are not empty then return true else return false
		 */
		if (mName != null && mYear !=null  && mGenre !=null && mPlot !=null && mDirector !=null ) {
			return true;
		} else {
			return false;
		}

	}
	
	

	private void readMovieFromDataBase() {
		MovieSQLiteHelper msdbh;
		SQLiteDatabase db;
		msdbh = new MovieSQLiteHelper(MovieDetailView.this, "DBMovie", null, 1);
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
		Log.d("Database Testing", name + year + genre + plot + director);
		} while (c.moveToNext());
		}
		db.close();
		}	
	
}
