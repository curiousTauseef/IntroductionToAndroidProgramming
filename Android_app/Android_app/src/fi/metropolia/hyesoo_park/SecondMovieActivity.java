package fi.metropolia.hyesoo_park;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SecondMovieActivity extends Activity {
	
	EditText et_movieName, et_movieYear, et_movieGenre, et_moviePlot, et_movieDirector;
	String movieName, movieYear, movieGenre, moviePlot, movieDirector;
	Button clear,done_button;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.second_movie_activity);
	et_movieName =(EditText)findViewById(R.id.et_moviename);
	et_movieYear =(EditText)findViewById(R.id.et_movieYear);
	et_movieGenre =(EditText)findViewById(R.id.et_movieGenre);
	et_moviePlot =(EditText)findViewById(R.id.et_moviePlot);
	et_movieDirector =(EditText)findViewById(R.id.et_movieDirector);
	done_button = (Button)findViewById(R.id.done_button);
	clear = (Button)findViewById(R.id.clear_button);
	}

	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		done_button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				getAndSendText();
			}
		});
		
   clear.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent in = new Intent();
			in.setClass(SecondMovieActivity.this,MainActivity.class);
			startActivity(in);
			finish();
			
		}
	});
	}
	
	protected void getAndSendText(){
		movieName = et_movieName.getText().toString();
		movieYear = et_movieYear.getText().toString();
		movieGenre = et_movieGenre.getText().toString();
		moviePlot = et_moviePlot.getText().toString();
		movieDirector = et_movieDirector.getText().toString();
		
		Intent in = new Intent();
		in.setClass(SecondMovieActivity.this,MovieDetailView.class);
		  in.putExtra("mName", movieName);
		  in.putExtra("mYear", movieYear);
		  in.putExtra("mGenre", movieGenre);
		  in.putExtra("mPlot", moviePlot);
		  in.putExtra("mDirector", movieDirector);
		  startActivity(in);
		  finish();
	}
	
	
}


