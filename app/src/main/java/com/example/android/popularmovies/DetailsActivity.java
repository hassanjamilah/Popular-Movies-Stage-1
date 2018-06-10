package com.example.android.popularmovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.popularmovies.utilities.NetworkUtils;
import com.squareup.picasso.Picasso;

public class DetailsActivity extends AppCompatActivity {


    private TextView date_TextView;
    private TextView votes_TextView;
    private TextView overview_TextView;

    private ImageView poster_ImageView;

    //used to store the data in the bundle in the case of rotation or ....
    private final String BUNDLE_KEY = "saveinstance" ;

    // used to store the data of the movie
    private Movie movie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        if (getSupportActionBar() != null){

            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        date_TextView = findViewById(R.id.movie_details_date);
        votes_TextView = findViewById(R.id.movie_details_vote);
        overview_TextView = findViewById(R.id.movie_details_overview);

        poster_ImageView = findViewById(R.id.movie_details_imageview);


        //Getting the data from the intent if exist
        Intent startedActivity = getIntent();
        String temp;

        movie = new Movie();


        //getting the date from the intent
        if (startedActivity.hasExtra(MainActivity.BUNDLE_DATE_KEY)) {
            temp = startedActivity.getStringExtra(MainActivity.BUNDLE_DATE_KEY);
            movie.setRelaeseDate(temp);

        }


        //getting the title from the intent
        if (startedActivity.hasExtra(MainActivity.BUNDLE_TITLE_KEY)) {
            temp = startedActivity.getStringExtra(MainActivity.BUNDLE_TITLE_KEY);
            movie.setTitle(temp);
        }


        //getting the rating from the intnet
        if (startedActivity.hasExtra(MainActivity.BUNDLE_VOTE_KEY)) {
            temp = startedActivity.getStringExtra(MainActivity.BUNDLE_VOTE_KEY);
            movie.setRating(temp);
        }

        /*
        getting the overview from the intent
         */
        if (startedActivity.hasExtra(MainActivity.BUNDLE_OVERVIEW_KEY)) {
            temp = startedActivity.getStringExtra(MainActivity.BUNDLE_OVERVIEW_KEY);
            movie.setOverView(temp);
        }

        /*
        getting the image name from the intent
         */
        if (startedActivity.hasExtra(MainActivity.BUNDLE_IMAGE_KEY)) {
            temp = startedActivity.getStringExtra(MainActivity.BUNDLE_IMAGE_KEY);
            movie.setImgeName(temp);
        }

        //used to diplay the data stored in the movie variable
        if (savedInstanceState != null && savedInstanceState.containsKey(BUNDLE_KEY)){
            movie = savedInstanceState.getParcelable(BUNDLE_KEY) ;
        }

        displayMovieData();

    }


    private void displayMovieData() {
        date_TextView.setText(movie.getRelaeseDate());
        if (getSupportActionBar() != null){
            getSupportActionBar().setTitle(movie.getTitle());
        }
        votes_TextView.setText(movie.getRating());
        overview_TextView.setText(movie.getOverView());
        Picasso.with(this).load(NetworkUtils.BASE_IMAGE_URL + movie.getImgeName()).into(poster_ImageView);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(BUNDLE_KEY , movie);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }
}
