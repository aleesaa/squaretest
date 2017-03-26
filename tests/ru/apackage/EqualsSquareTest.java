package ru.apackage;

import org.junit.Test;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by AMaslovskaya on 24.03.2017.
 */

public class EqualsSquareTest {

    @Test
    public void assertEqualsSquare() throws Exception {

        positiveAssertSquare(10, 10);
    }

    @Test
    public void assertNotEqualsSquare() throws Exception {

        negativeAssertSquare(1000.0, 1100.0);
    }

    @Test
    public void assertEqualsSquareWithMinDelta() throws Exception {
        negativeAssertSquare(0.0, 0.0+4.9e-324);
    }

    @Test
    public void assertEqualsSquareWithNegativeSideLength() throws Exception {

        positiveAssertSquare(40.0, -40.0);
    }

    @Test
    public void assertEqualsSquareWithMaxSideLength() throws Exception {

        positiveAssertSquare(Double.MAX_VALUE, Double.MAX_VALUE);
    }

    @Test
    public void assertEqualsSquareWithMinSideLength() throws Exception {

        positiveAssertSquare(Double.MIN_VALUE, Double.MIN_VALUE);
    }


    private void positiveAssertSquare(double sideLength1, double sideLength2) {
        Square square = SquareFactory.newSquare(sideLength1);
        Square square2 = SquareFactory.newSquare(sideLength2);
        assertTrue("Result: NOK, where sideLength1 = "+sideLength1+" and sideLength2 = "+sideLength2, square.equalsSquare(square2));
    }

    private void negativeAssertSquare(double sideLength1, double sideLength2) {
        Square square = SquareFactory.newSquare(sideLength1);
        Square square2 = SquareFactory.newSquare(sideLength2);
        assertFalse("Result: NOK, where sideLength1 = "+sideLength1+" and sideLength2 = "+sideLength2, square.equalsSquare(square2));
    }
}
