package com.movierental;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.junit.runners.Suite;

import static junit.framework.TestCase.assertTrue;

public class CustomerTest {

    private Customer customer;

    @Before
    public void setup() {
        customer = new Customer("Sergii");

        Rental r1 = new Rental(new Movie("Matrix", Movie.REGULAR), 4);
        Rental r2 = new Rental(new Movie("Matrix 2", Movie.NEW_RELEASES), 7);
        Rental r3 = new Rental(new Movie("Panda Kung Fu", Movie.CHILDRENS), 2);

        customer.addRental(r1);
        customer.addRental(r2);
        customer.addRental(r3);
    }

    @After
    public void tearDown() {
        customer = null;
    }

    @Test
    public void testStatement() throws Exception {
        assertTrue("Total amount is incorrect", customer.statement().contains("Total amount to pay 27.5"));
        assertTrue("Matrix price is incorrect", customer.statement().contains("Matrix\t5.0"));
        assertTrue("Matrix price is incorrect", customer.statement().contains("Matrix 2\t21.0"));
        assertTrue("Matrix price is incorrect", customer.statement().contains("Panda Kung Fu\t1.5"));
    }



    @Test
    public void testHtmlStatement() throws Exception {
        assertTrue("Total amount is incorrect", customer.htmlStatement()
                .contains("<P>Total amount to pay <EM>27.5</EM><P>"));
        assertTrue("Matrix price is incorrect", customer.htmlStatement().contains("Matrix:5.0"));
        assertTrue("Matrix price is incorrect", customer.htmlStatement().contains("Matrix 2:21.0"));
        assertTrue("Matrix price is incorrect", customer.htmlStatement().contains("Panda Kung Fu:1.5"));

    }


}