package com.movierental;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        this.rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public String statement() {
        double totalAmount = 0;
        int frequentrenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rent for " + getName() + "/n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();


            //add points for active renter
            frequentrenterPoints++;
            // bonus if rent new release for two days
            if (each.getMovie().getPriceCode() == Movie.NEW_RELEASES &&
                    each.getDaysRented() > 1) frequentrenterPoints++;
            // Show results for current rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

            totalAmount += each.getCharge();
        }

        result += "Total amount to pay " + String.valueOf(totalAmount) + "\n";
        result += "You have earned " + String.valueOf(frequentrenterPoints) + " points for activities.";
        return result;
    }

}

