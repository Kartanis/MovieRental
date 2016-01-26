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
        int frequentrenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        String result = "Rent for " + getName() + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();

            // Show results for current rental
            result += "\t" + each.getMovie().getTitle() + "\t" + String.valueOf(each.getCharge()) + "\n";

        }

        result += "Total amount to pay " + String.valueOf(getTotalCharge()) + "\n";
        result += "You have earned " + String.valueOf(getFrequentrenterPoints()) + " points for activities.";
        return result;
    }

    public String htmlStatement() {
        Enumeration rentals = this.rentals.elements();
        String result = "<H1>Rental operations for <EM>"
                + getName() + "</EM></H1>\n";
        while(rentals.hasMoreElements()) {
            Rental each = (Rental)rentals.nextElement();
            result += each.getMovie().getTitle() + ":" + String.valueOf(each.getCharge()) + "<BR>\n";
        }

        result += "<P>Total amount to pay <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
        result += "You have earned <EM>" + String.valueOf(getFrequentrenterPoints()) + "</EM> points for activities.<P>";
        return result;
    }

    private int getFrequentrenterPoints() {
        int frequentRenterPoints = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            frequentRenterPoints += each.getFrequentRenterPoints();
        }

        return frequentRenterPoints;
    }

    private double getTotalCharge() {
        double result = 0;
        Enumeration rentals = this.rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }

        return result;
    }

}

