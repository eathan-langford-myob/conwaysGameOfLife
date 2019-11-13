package com.conwaysGameOfLife.IO;

import com.conwaysGameOfLife.Coordinate;
import org.hamcrest.CoreMatchers;
import org.junit.*;

import java.util.ArrayList;

public class ConsoleInputTest {
    ConsoleInput input;

    @Before
    public void setUp() {
        input = new ConsoleInput();
    }

    @After
    public void tearDown() {
        input = null;
    }

    @Test
    public void shouldReturnStringGiven_WhenUserInputIsCalled() {
        IInput userInput = new ConsoleInputMock("Hello World");

        String actual = userInput.nextLine();
        String expected = "Hello World";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnSingleParsedCoordinate_WhenGivenString() {
        String userInput = "3,2";

        Coordinate actual = input.parseSingleCoordinate(userInput);
        Coordinate expected = new Coordinate(3,2);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCoordinateArrayOfUserInput_WhenParsed() {
        ArrayList<Coordinate> arrayOfCoordinates = new ArrayList<>();
        arrayOfCoordinates.add(new Coordinate(2, 2));
        arrayOfCoordinates.add(new Coordinate(3, 3));

        ArrayList<Coordinate> actual = input.parseUserInputToCoordinates("2,2/3,3");
        ArrayList<Coordinate> expected = arrayOfCoordinates;

        Assert.assertEquals(expected, actual);
    }

}
