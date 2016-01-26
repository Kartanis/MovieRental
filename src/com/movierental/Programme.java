package com.movierental;

public class Programme {

    public static void main(String[] args) {
        Customer customer = new Customer("Sergii");
        Rental r1 = new Rental(new Movie("Matrix", Movie.REGULAR), 4);
        Rental r2 = new Rental(new Movie("Matrix 2", Movie.NEW_RELEASES), 7);
        Rental r3 = new Rental(new Movie("Panda Kung Fu", Movie.CHILDRENS), 2);

        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);
        System.out.println(customer.htmlStatement());
    }
}
