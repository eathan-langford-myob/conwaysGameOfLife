package com.conwaysgameoflife.io;

import com.conwaysgameoflife.grid.Grid;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GridInputValidatorTest {
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
        boolean actual = GridInputValidator.isValidSingleCoordinateFormat(userInputValidString);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalse_WhenNotValidFormatString() {
        String inputInvalidString = "3.1";

        boolean actual = GridInputValidator.isValidSingleCoordinateFormat(inputInvalidString);

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrue_WhenIntegersWithinBoundsOfGrid() {
        boolean actual = GridInputValidator.isValidInputWithinBoardRange(userInputValidString, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForValidInput_WhenGivenStringOfCoordinates() {
        String userInput = "2,3/3,3/4,4/1,2";

        boolean actual = GridInputValidator.isValidFormat(userInput, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForValidInput_WhenGivenStringOfCoordinatesOverTen() {
        largeGrid = new Grid(100, 100);
        String userInput = "20,30/20,31/20,32/19,32/18,31";

        boolean actual = GridInputValidator.isValidFormat(userInput, largeGrid.getGridWidth(), largeGrid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForPositiveIntegerFromInput() {
        String userInput = "2";
        boolean actual = GridInputValidator.isPositiveInteger(userInput);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturFalseForInvalidPositiveIntegerFromInput() {
        String userInput = "-1";
        boolean actual = GridInputValidator.isPositiveInteger(userInput);

        Assert.assertFalse(actual);
    }
}
