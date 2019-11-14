package com.conwaysGameOfLife.IO;

import com.conwaysGameOfLife.Coordinate;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class InputParserTest {
    ConsoleInput input;
    InputParser parser;

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
        String userInput = "3,2";

        Coordinate actual = parser.parseSingleCoordinate(userInput);
        Coordinate expected = new Coordinate(3,2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCoordinateArrayOfUserInput_WhenParsed() {
        ArrayList<Coordinate> arrayOfCoordinates = new ArrayList<>();
        arrayOfCoordinates.add(new Coordinate(2, 2));
        arrayOfCoordinates.add(new Coordinate(3, 3));

        ArrayList<Coordinate> actual = parser.parseUserInputToCoordinates("2,2/3,3");
        ArrayList<Coordinate> expected = arrayOfCoordinates;

        Assert.assertEquals(expected, actual);
    }

}
