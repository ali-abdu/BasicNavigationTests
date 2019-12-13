package com.cbt.tests.WednesdayReview;

public class Movie {


    //rating (e.g., Rated G, PG-13, R), ID Number, and movie title with
    private String rating;
    private int idNumber;
    private String title;

    //accessor and mutator methods. means getter and setter methods


    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    //based on our criteria, check if 2 object are same
    @Override
    public boolean equals(Object object) {
        Movie movie = (Movie) object;
        return this.idNumber == movie.getIdNumber();
    }

    //to describe object
    @Override
    public String toString() {
        return "Action{" +
                "rating='" + getRating() + '\'' +
                ", idNumber=" + getIdNumber() +
                ", title='" + getTitle() + '\'' +
                '}';
    }

    public double calculateFees(int days){
        return days*2;
    }

public Movie getMovieId(Movie[]movies,int movieId){
    for (Movie m : movies) {
        if (m.idNumber==movieId){
            return m;
        }
    }
         return null;
}
}

