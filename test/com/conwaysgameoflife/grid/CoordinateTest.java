package com.conwaysgameoflife.grid;

import com.conwaysgameoflife.grid.Coordinate;
import org.junit.*;

import static org.junit.Assert.*;

public class CoordinateTest {
    private Coordinate coordinate;

    @Before
    public void setUp() {
        coordinate = new Coordinate(2,2);
    }

    @After
    public void tearDown() {
        coordinate = null;
    }

    @Test
    public void shouldReturnIncrementedCoordinate_WhenMovingHorizontal() {
        Coordinate actual = coordinate.incrementX();
        Coordinate expected = new Coordinate(3,2);

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnIncrementedCoordinate_WhenMovingVertical() {
        Coordinate actual = coordinate.incrementY();
        Coordinate expected = new Coordinate(2,3);

        assertEquals(expected, actual);
    }

}
