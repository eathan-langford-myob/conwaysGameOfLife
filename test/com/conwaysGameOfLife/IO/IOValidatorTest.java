package com.conwaysGameOfLife.IO;

import com.conwaysGameOfLife.*;
import org.junit.*;

public class IOValidatorTest {
    private String userInputValidString;
    private Grid grid;

    @Before
    public void setUp(){
        userInputValidString = "3,1";
        grid = new Grid(5,5);
    }

    @After
    public void tearDown(){
        userInputValidString = null;
        grid = null;
    }

    @Test
    public void shouldReturnTrue_WhenValidFormatString(){
        boolean actual = IOValidator.isValidCoordinateFormat(userInputValidString);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenIntegersWithinBoundsOfGrid() {
        boolean actual = IOValidator.isValidInputWithinBoardRange(userInputValidString, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForValidInput_WhenGivenStringOfCoordinates() {
        String userInput = "2,3/3,3/4,4/1,2";

        boolean actual = IOValidator.validateUserInput(userInput, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }
}
