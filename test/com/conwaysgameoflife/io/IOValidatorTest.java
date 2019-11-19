package com.conwaysgameoflife.io;

import com.conwaysgameoflife.Grid;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class IOValidatorTest {
    private String userInputValidString;
    private Grid grid;
    private Grid largeGrid;

    @Before
    public void setUp() {
        userInputValidString = "3,1";
        grid = new Grid(5, 5);
    }

    @After
    public void tearDown() {
        userInputValidString = null;
        grid = null;
    }

    @Test
    public void shouldReturnTrue_WhenValidFormatString() {
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

    @Test
    public void shouldReturnTrueForValidInput_WhenGivenStringOfCoordinatesOverTen() {
        largeGrid = new Grid(100, 100);
        String userInput = "20,30/20,31/20,32/19,32/18,31";

        boolean actual = IOValidator.validateUserInput(userInput, largeGrid.getGridWidth(), largeGrid.getGridHeight());

        Assert.assertTrue(actual);
    }
}
