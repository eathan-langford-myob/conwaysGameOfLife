package com.conwaysgameoflife.io;

import com.conwaysgameoflife.grid.Grid;
import org.junit.Assert;
import org.junit.Test;

public class GridInputValidatorTest {
    private String inputValidString;
    private Grid grid;

    @Test
    public void shouldReturnTrue_WhenValidFormatString() {
        inputValidString = "3,1";

        boolean actual = GridInputValidator.isValidSingleCoordinateFormat(inputValidString);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalse_WhenInvalidFormatString() {
        String inputInvalidString = "3.1";

        boolean actual = GridInputValidator.isValidSingleCoordinateFormat(inputInvalidString);

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrue_WhenIntegersWithinBoundsOfGrid() {
        grid = new Grid(5, 5);
        inputValidString = "3,1";

        boolean actual = GridInputValidator.isValidInputWithinBoardRange(inputValidString, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForValidInput_WhenGivenStringOfCoordinates() {
        grid = new Grid(5, 5);
        String input = "2,3/3,3/4,4/1,2";

        boolean actual = GridInputValidator.isValidFormat(input, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueForValidInput_WhenGivenStringOfCoordinatesOverTen() {
        grid = new Grid(100, 100);
        String input = "20,30/20,31/20,32/19,32/18,31";

        boolean actual = GridInputValidator.isValidFormat(input, grid.getGridWidth(), grid.getGridHeight());

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenPositiveInteger() {
        String input = "2";
        boolean actual = GridInputValidator.isPositiveInteger(input);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalse_WhenInvalidPositiveInteger() {
        String input = "-1";
        boolean actual = GridInputValidator.isPositiveInteger(input);

        Assert.assertFalse(actual);
    }
}
