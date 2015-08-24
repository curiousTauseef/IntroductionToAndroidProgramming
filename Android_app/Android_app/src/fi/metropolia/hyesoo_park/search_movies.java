package fi.metropolia.hyesoo_park;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class search_movies extends Activity implements AsyncResponse {

	EditText et_Search;
	Button btn_Search;
	TextView tv_Result;
	Button Detail_View;
	String movieName, movieYear, movieGenre, moviePlot, movieDirector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		et_Search = (EditText) findViewById(R.id.et_Search);
		btn_Search = (Button) findViewById(R.id.btn_Search);
		tv_Result = (TextView) findViewById(R.id.tv_Result);
        Detail_View = (Button) findViewById(R.id.Detail_View);
        
        //Detail_View.setVisibility(8);
	}

	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		btn_Search.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if (et_Search.getText().toString().length() > 0) {
					searchTitle(et_Search.getText().toString());
				} else {
					Toast.makeText(search_movies.this, "Search Box empty",
							Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		Detail_View.setOnClickListener(new View.OnClickListener() {
			      
			@Override
			public void onClick(View v) {
				Intent in = new Intent();
				in.setClass(search_movies.this, MovieDetailView.class);
				in.putExtra("mName", movieName);
				in.putExtra("mYear", movieYear);
				in.putExtra("mGenre", movieGenre);
				in.putExtra("mPlot", moviePlot);
				in.putExtra("mDirector", movieDirector);
				startActivity(in);
			
				finish();

	}
		});
	}
		
	protected void searchTitle(String title) {
		title = title.replace(" ", "%20");
		String url = "http://www.omdbapi.com/?t=" + title;
		SearchTask searchTask = new SearchTask();
		searchTask.delegate = this;
		searchTask.execute(url);
		Toast.makeText(getBaseContext(), R.string.searchmovie,
				Toast.LENGTH_LONG).show();
	}

	@Override
	public void processFinish(String searchResults) {
		Movie movie = createMovieObjectFromJSON(searchResults);
		displayMovieObject(movie);
	} 

	private Movie createMovieObjectFromJSON(String searchResults) {
		String name, year, genre, plot, director;
		Movie movie = null;
		try {
			JSONObject jObject = new JSONObject(searchResults);
			if (jObject.has("Title")) {
			    name = jObject.get("Title").toString();
				movieName = jObject.get("Title").toString();
			} else {
				//movieName = "Name not found";
				name = "Name not found";
			}
			if (jObject.has("Year")) {
				movieYear = jObject.get("Year").toString();
				year = jObject.get("Year").toString();
				
			} else {
				//movieYear = "Year not found";
				year  = "Year not found";
			}
			if (jObject.has("Genre")) {
				movieGenre = jObject.get("Genre").toString();
				genre = jObject.get("Genre").toString();
			} else {
				//movieGenre = "Genre not found";
				genre = "Genre not found";
			}
			if (jObject.has("Plot")) {
				moviePlot = jObject.get("Plot").toString();
				plot = jObject.get("Plot").toString();
			} else {
				//moviePlot = "Plot not found";
				plot = "Plot not found";
			}
			if (jObject.has("Director")) {
				movieDirector = jObject.get("Director").toString();
				director = jObject.get("Director").toString();
			} else {
				//movieDirector = "Director not found";
				director = "Director not found";
				
			}
			movie = new Movie(name, year,genre, plot, director);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movie;
	}

	private void displayMovieObject(Movie movie) {
		String result;
		result = "Found " + movie.getName() + "(" + movie.getYear() + ")";
		tv_Result.setText(result);
		Detail_View.setVisibility(0);
		//movieName = movie.getName();
		
	}


}
