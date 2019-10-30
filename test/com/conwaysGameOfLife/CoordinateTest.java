package com.conwaysGameOfLife;

import org.junit.Test;

import static org.junit.Assert.*;

public class CoordinateTest {
    Coordinate coordinates;


    @Test
    public void shouldReturnIntegerRepresentingXCoordinate() {
        coordinates = new Coordinate(2,0);
        int actual = coordinates.getX();
        int expected = 2;

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIntegerRepresentingYCoordinate() {
        coordinates = new Coordinate(0,2);
        int actual = coordinates.getY();
        int expected = 2;

        assertEquals(expected,actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinateHorizontal() {
        coordinates = new Coordinate(0,0);
        Coordinate actual = coordinates.incrementX();
        Coordinate expected = new Coordinate(1,0);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinateVertical() {
        coordinates = new Coordinate(0,0);
        Coordinate actual = coordinates.incrementY();
        Coordinate expected = new Coordinate(0,1);

        assertEquals(expected, actual);
    }

}
