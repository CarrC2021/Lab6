package up.edu.dimcalc;

import android.graphics.Point;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoPointsTest {

    @Test
    public void getPoint() {
        TwoPoints points = new TwoPoints();
        points.setPoint(0, 2,7);
        points.setPoint(1,-1029, 8754);
        points.getPoint(0);
        assertEquals("values tested are points", new Point(2 , 7), points.getPoint(0));
        assertEquals("values tested are points", new Point(-1029, 8754), points.getPoint(1));
    }

    @Test
    public void setPoint() {
        TwoPoints points = new TwoPoints();
        points.setPoint(0, 2,7);
        points.setPoint(1,-1029, 8754);
        points.getPoint(0);
        assertEquals("values tested are points", new Point(2 , 7), points.getPoint(0));
        assertEquals("values tested are points", new Point(-1029, 8754), points.getPoint(1));
    }

    @Test
    public void randomValue() {
        TwoPoints points = new TwoPoints();
        points.randomValue(0);
        points.randomValue(1);

    }

    @Test
    public void setOrigin() {
        TwoPoints points = new TwoPoints();
        points.setOrigin(0);
        points.setOrigin(1);
        assertEquals(new Point(0,0), points.getPoint(0));
        assertEquals(new Point(0,0), points.getPoint(1));
    }

    @Test
    public void copy() {
    }

    @Test
    public void distance() {
        TwoPoints points = new TwoPoints();
        points.setPoint(0, 12, 3);
        points.setPoint(1, 6, 4);
        double result = 0.0;
        int xDiff = 12 - 6;
        int yDiff = 3 - 4;
        result = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        assertEquals(result, points.distance(), .001);
        points.setPoint(0, 34, 6);
        points.setPoint(1, -2345, - 4);
        result = 0.0;
        xDiff = 34 + 2345;
        yDiff = 6 + 4;
        result = Math.sqrt(xDiff*xDiff + yDiff*yDiff);
        assertEquals(result, points.distance(), .001);
    }

    @Test
    public void slope() {
        TwoPoints points = new TwoPoints();
        points.setPoint(0, 7, 3);
        points.setPoint(1, 234, -3);
        double result = 0.0;
        int xDiff = 7 - 3;
        int yDiff = 234 + 3;
        result = xDiff / yDiff;
        assertEquals(result, points.slope(), .001);
        points.setPoint(0, 7, 3);
        points.setPoint(1, 456, -7);
        result = 0.0;
        xDiff = 7 - 456;
        yDiff = 3 + 7;
        result = xDiff / yDiff;
        assertEquals(result, points.slope(), .001);
    }
}