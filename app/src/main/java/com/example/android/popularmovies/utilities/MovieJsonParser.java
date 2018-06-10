package com.example.android.popularmovies.utilities;


import com.example.android.popularmovies.Movie;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;

public class MovieJsonParser {

    /**
     * defining the keys that will be used to parse the JSON File
     * Main key is results
     *
     */
    private static final String results_key = "results";
    private static final String TITLE_KEY = "title";
    private static final String IMAGE_KEY = "poster_path";
    private static final String OVERVIEW_KEY = "overview";
    private static final String DATE_KEY = "release_date";
    private static final String VOTES_KEY = "vote_average";
    private static final String ID_KEY = "id";


    /**
     * used to parse the movie data from the json result
     * @param jsonString the string that were obtained from the query
     * @return returning the list of movies
     * @throws JSONException  if an error occured throwing the exception
     */
    public ArrayList<Movie> parseMove(String jsonString) throws JSONException {
        ArrayList<Movie> resultMovies = new ArrayList<>();

        // getting the main object
        JSONObject results = new JSONObject(jsonString);

        // reading the list of movies from the result object
        JSONArray movies1 = results.getJSONArray(results_key);


        Movie mov  ;
        // reading and storing the data of the movies in an arraylist
        for (int i = 0; i < movies1.length(); i++) {
            mov = new Movie()  ;
            JSONObject obj = movies1.getJSONObject(i);
            mov.setId(obj.getInt(ID_KEY));
            mov.setImgeName(obj.getString(IMAGE_KEY));
            mov.setOverView(obj.getString(OVERVIEW_KEY));
            mov.setRating(obj.getString(VOTES_KEY));
            mov.setRelaeseDate(obj.getString(DATE_KEY));
            mov.setTitle(obj.getString(TITLE_KEY));
            resultMovies.add(mov) ;
        }

        // returning the result of the movies
        return resultMovies;
    }
}
