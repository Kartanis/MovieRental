package com.movierental;

public class Programme {

    public static void main(String[] args) {
        Customer customer = new Customer("Sergii");
        Rental r1 = new Rental(new Movie("Matrix", Movie.REGULAR), 4);
        customer.addRental(r1);
        System.out.println(customer.htmlStatement());
    }
}
