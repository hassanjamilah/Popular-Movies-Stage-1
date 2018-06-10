package com.example.android.popularmovies.utilities;


import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class NetworkUtils {

    //ToDo Most be deleted before publishing
    private static final String API_KEY = "";

    // defining the urls for each getting type for the popular or top rated movies
    public static final String ORDER_BY_RATING_URL = "http://api.themoviedb.org/3/movie/top_rated?";
    public static final String ORDER_BY_POPULAR_URL = "http://api.themoviedb.org/3/movie/popular?";

    //the api key to be used in the query
    private static final String API_KEY_QUERY = "api_key";

    // the url to get the movie image
    public static final String BASE_IMAGE_URL = "http://image.tmdb.org/t/p/w185/";


    /**
     * used to get the url that will be used to get the movies from the moviedb
     * @param orderByBaseUrl used to choose between popular or top rated movies
     * @return return the url
     * @throws MalformedURLException if an error occured throws an exception
     */
    public static URL getUrl(String orderByBaseUrl) throws MalformedURLException {
        Uri myUri = Uri.parse(orderByBaseUrl).buildUpon()
                .appendQueryParameter(API_KEY_QUERY, API_KEY)
                .build();

        return new URL(myUri.toString());
    }


    /**
     * used to get the respond from the server and return the result as string
     * @param url the url we built.
     * @return return the result as string
     * @throws IOException if an error occured throws an error exception
     */
    public String getHttpResponse(URL url) throws IOException {
        //oepening the conneciton
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        //x is used to store all the data
        StringBuilder x = new StringBuilder();
        try {
            InputStream in = con.getInputStream();
            Scanner scanner = new Scanner(in);
            while (scanner.hasNext()) {
                x.append(" ").append(scanner.next());
            }
        } finally {
            //closing the connection to free resources
            con.disconnect();
        }

        return x.toString();
    }
}
