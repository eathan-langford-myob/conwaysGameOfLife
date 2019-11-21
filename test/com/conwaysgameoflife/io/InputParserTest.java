package com.conwaysgameoflife.io;

import com.conwaysgameoflife.grid.Coordinate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class InputParserTest {
    private InputParser parser;

    @Before
    public void setUp() {
        parser = new InputParser();
    }

    @After
    public void tearDown() {
        parser = null;
    }

    @Test
    public void shouldReturnSingleParsedCoordinate_WhenGivenString() {
        String input = "3,2";

        Coordinate actual = parser.parseSingleCoordinate(input);
        Coordinate expected = new Coordinate(2,1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCoordinateArrayOfInput_WhenParsed() {
        ArrayList<Coordinate> arrayOfCoordinates = new ArrayList<>();
        arrayOfCoordinates.add(new Coordinate(1, 1));
        arrayOfCoordinates.add(new Coordinate(2, 2));

        ArrayList<Coordinate> actual = parser.parseInputToCoordinates("2,2/3,3");

        Assert.assertEquals(arrayOfCoordinates, actual);
    }

}
