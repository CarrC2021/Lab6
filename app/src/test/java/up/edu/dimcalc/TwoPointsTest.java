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
        Point p1 = new Point(2 , 7);
        Point p2 = new Point(-1029, 8754);
        assertEquals(2, points.getPoint(0).x);
        assertEquals(-1029, points.getPoint(1).x);
    }

    @Test
    public void setPoint() {
        TwoPoints points = new TwoPoints();
        points.setPoint(0, 2,7);
        points.setPoint(1,-1029, 8754);
        Point p1 = new Point(2 , 7);
        Point p2 = new Point(-1029, 8754);
        assertEquals(2, points.getPoint(0).x);
        assertEquals(-1029, points.getPoint(1).x);
        assertEquals(8754, points.getPoint(1).y);
    }

    @Test
    public void randomValue() {
        TwoPoints points = new TwoPoints();
        points.randomValue(0);
        points.randomValue(1);

        assertEquals(points.getPoint(0).x, points.getPoint(0).y, 20);
        assertEquals(points.getPoint(1).x, points.getPoint(1).y, 20);

        points.randomValue(0);
        points.randomValue(1);

        assertEquals(points.getPoint(0).x, points.getPoint(0).y, 20);
        assertEquals(points.getPoint(1).x, points.getPoint(1).y, 20);

        points.randomValue(0);
        points.randomValue(1);

        assertEquals(points.getPoint(0).x, points.getPoint(0).y, 20);
        assertEquals(points.getPoint(1).x, points.getPoint(1).y, 20);

        points.randomValue(0);
        points.randomValue(1);

        assertEquals(points.getPoint(0).x, points.getPoint(0).y, 20);
        assertEquals(points.getPoint(1).x, points.getPoint(1).y, 20);
    }

    @Test
    public void setOrigin() {
        TwoPoints points = new TwoPoints();
        points.setOrigin(0);
        points.setOrigin(1);
        assertEquals(0, points.getPoint(0).x);
        assertEquals(0, points.getPoint(1).y);
    }

    @Test
    public void copy() {
        TwoPoints points = new TwoPoints();
        points.setOrigin(0);
        points.setPoint(1, -13,4);
        points.copy(1,0);
        assertEquals(points.getPoint(1).x, points.getPoint(0).x);
        assertEquals(points.getPoint(0).y, points.getPoint(1).y);
        points.setPoint(1, -12, 4);
        assertNotEquals(points.getPoint(1).y, points.getPoint(0).y);

        //this fails because it sets one object to be equivalent to the other instead of just copying its variables over
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
        double xDiff = 7 - 3;
        double yDiff = 234 + 3;
        result = yDiff / xDiff;
        assertEquals(result, points.slope(), .01);
        points.setPoint(0, 7, 3);
        points.setPoint(1, 456, -7);
        xDiff = 7 - 456;
        yDiff = 3 + 7;
        result = yDiff / xDiff;
        assertEquals(result, points.slope(), .001);

        //this throws an error because the slope method is flawed and uses xDiff/yDiff instead of yDiff/xDiff
    }
}