package ru.apackage;

import junit.framework.TestCase;
import org.junit.Test;
import ru.socialquantum.testtasks.Square;
import ru.socialquantum.testtasks.SquareFactory;

import java.util.Random;

/**
 * Created by AMaslovskaya on 24.03.2017.
 */

public class SquareTest extends TestCase {

    @Test
    public void testPositiveSquare() throws Exception {
        assertSquare(5.0);
    }

    @Test
    public void testPositiveSquareWithTwoDigitNumberSideLength() throws Exception {
        assertSquare(15.2);
    }

    @Test
    public void testPositiveSquareWithThreeDigitNumberSideLength() throws Exception {
        assertSquare(999999.9999999999);
    }

    @Test
    public void testSquareWithMinSideLength() throws Exception {
        assertSquare(Double.MIN_VALUE);
    }

    @Test
    public void testSquareWithMaxSideLength() throws Exception {
        assertSquare(Double.MAX_VALUE);
    }

    @Test
    public void testSquareWithNegativeMinSideLength() throws Exception {
        assertSquare(-Double.MIN_VALUE);
    }

    @Test
    public void testSquareWithNegativeMaxSideLength() throws Exception {
        assertSquare(-Double.MAX_VALUE);
    }

    @Test
    public void testSquareWithRandomSideLength() throws Exception {
        Random r = new Random();
        double sideLength = Double.MIN_VALUE + (Double.MAX_VALUE - Double.MIN_VALUE) * r.nextDouble();
        System.out.println("Random sideLength: "+sideLength);
        assertSquare(sideLength);
    }

    private void assertSquare(double sideLength) {
        Square square = SquareFactory.newSquare(sideLength);
        double actual = square.square();
        double expected = sideLength * sideLength;

        assertEquals("Result: NOK, where sideLength: "+sideLength, expected, actual, 0);
    }

}
