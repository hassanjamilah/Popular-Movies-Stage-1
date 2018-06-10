package com.example.android.popularmovies;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private String title ;
    private String imgeName ;
    private String rating ;
    private String relaeseDate ;
    private String overView ;
    private int id ;

    public Movie(){}

    /*public Movie(String title, String imgeName, String rating, String relaeseDate, String overView, int id) {
        this.title = title;
        this.imgeName = imgeName;
        this.rating = rating;
        this.relaeseDate = relaeseDate;
        this.overView = overView;
        this.id = id;
    }*/

    private Movie(Parcel in) {
        title = in.readString();
        imgeName = in.readString();
        rating = in.readString();
        relaeseDate = in.readString();
        overView = in.readString();
        id = in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(imgeName);
        dest.writeString(rating);
        dest.writeString(relaeseDate);
        dest.writeString(overView);
        dest.writeInt(id);
    }


   /* public String toString(){
        StringBuilder builder;
        builder = new StringBuilder();
        builder.append("Movie Title: ").append(title);
        builder.append("\nMovie Image Name: " + imgeName) ;
        builder.append("\nMovie Rating: " + rating) ;
        builder.append("\nMovie Release Date: " + relaeseDate) ;
        builder.append("\nMovie Overview: " + overView) ;
        builder.append("\nMovie id: " + String.valueOf(id)) ;
         return builder.toString() ;
    }*/

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgeName() {
        return imgeName;
    }

    public void setImgeName(String imgeName) {
        this.imgeName = imgeName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getRelaeseDate() {
        return relaeseDate;
    }

    public void setRelaeseDate(String relaeseDate) {
        this.relaeseDate = relaeseDate;
    }

    public String getOverView() {
        return overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }



    public void setId(int id) {
        this.id = id;
    }
}
