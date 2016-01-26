package com.movierental;

public class Rental {
    Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    /*
            add points for active renter
            bonus if rent new release for two days
        */
    int getFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);

    }

    public double getCharge() {
        return movie.getCharge(getDaysRented());
    }
}
