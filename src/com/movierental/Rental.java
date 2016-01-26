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
        if (getMovie().getPriceCode() == Movie.NEW_RELEASES &&
                daysRented > 1)
            return 2;
        else
            return 1;
    }

    public double getCharge() {
        return movie.getCharge(getDaysRented());
    }
}
