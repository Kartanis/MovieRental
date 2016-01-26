package com.movierental;

import org.testng.annotations.Test;

import static junit.framework.TestCase.assertTrue;
import static org.testng.AssertJUnit.assertEquals;

public class CustomerTest {

    @Test
    public void testStatement() throws Exception {
        Customer customer = new Customer("Sergii");
        Rental r1 = new Rental(new Movie("Matrix", Movie.REGULAR), 4);
        customer.addRental(r1);
        assertTrue("", customer.statement().contains("Total amount to pay 5.0"));
    }



    @Test
    public void testHtmlStatement() throws Exception {
        Customer customer = new Customer("Sergii");
        Rental r1 = new Rental(new Movie("Matrix", Movie.REGULAR), 4);
        customer.addRental(r1);
        assertTrue("", customer.htmlStatement().contains("<P>Total amount to pay <EM>5.0</EM><P>"));

    }
}