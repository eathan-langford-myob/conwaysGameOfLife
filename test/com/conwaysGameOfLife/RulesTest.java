package com.conwaysGameOfLife;

import org.junit.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class RulesTest {
    private Grid grid;
    Cell[] neighbors;

    @Before
    public void setUp() {
        grid = new Grid(3, 3);
    }

    @Test
    public void shouldReturnNumberOfLiveNeighbors_WhenQueryingRules() {
        grid.getCell(new Coordinate(1, 0)).makeCellAlive();
        grid.getCell(new Coordinate(2, 0)).makeCellAlive();
        grid.getCell(new Coordinate(0, 2)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));

        long actual = Rules.getNumberOfLiveCellsFromNeighbors(neighbors);
        long expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy3LiveCells() {
        grid.getCell(new Coordinate(1, 0)).makeCellAlive();
        grid.getCell(new Coordinate(2, 2)).makeCellAlive();
        grid.getCell(new Coordinate(1, 2)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCell(new Coordinate(1, 1));

        boolean actual = Rules.calculateCellLifeExpectancy(queriedCell, neighbors);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy2LiveCells() {
        grid.getCell(new Coordinate(1, 0)).makeCellAlive();
        grid.getCell(new Coordinate(2, 0)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCell(new Coordinate(1, 1));
        queriedCell.makeCellAlive();

        boolean actual = Rules.calculateCellLifeExpectancy(queriedCell, neighbors);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnDeadCell_WhenSurroundedBy4LiveCells() {
        grid.getCell(new Coordinate(1, 0)).makeCellAlive();
        grid.getCell(new Coordinate(2, 0)).makeCellAlive();
        grid.getCell(new Coordinate(2, 2)).makeCellAlive();
        grid.getCell(new Coordinate(0, 1)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCell(new Coordinate(1, 1));
        queriedCell.makeCellAlive();

        boolean actual = Rules.calculateCellLifeExpectancy(queriedCell, neighbors);

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnFalse_WhenSurroundedByLessThan3LiveCells() {
        grid.getCell(new Coordinate(1, 0)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCell(new Coordinate(1, 1));
        queriedCell.makeCellAlive();

        boolean actual = Rules.calculateCellLifeExpectancy(queriedCell, neighbors);

        Assert.assertFalse(actual);
    }


    @Test
    public void shouldReturnArrayOfNextGenerationCoordinates_WhenGridHas3LiveCells_PropellerPattern() {
        Grid grid = new Grid(5, 5);
        grid.getCell(new Coordinate(2, 1)).makeCellAlive();
        grid.getCell(new Coordinate(2, 2)).makeCellAlive();
        grid.getCell(new Coordinate(2, 3)).makeCellAlive();

        ArrayList<Coordinate> expectedGrid = new ArrayList<>();
        expectedGrid.add(new Coordinate(1, 2));
        expectedGrid.add(new Coordinate(2, 2));
        expectedGrid.add(new Coordinate(3, 2));
        expectedGrid.sort(Comparator.comparing(Coordinate::getX));

        ArrayList<Coordinate> actual = Rules.getCoordinatesOfNextGenerationsCells(grid);
        ArrayList<Coordinate> expected = expectedGrid;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfSameCoordinates_WhenGridHas4LiveCells_StillLifeBlockPattern() {
        Grid grid = new Grid(5, 5);
        grid.getCell(new Coordinate(2, 1)).makeCellAlive();
        grid.getCell(new Coordinate(2, 2)).makeCellAlive();
        grid.getCell(new Coordinate(1, 1)).makeCellAlive();
        grid.getCell(new Coordinate(1, 2)).makeCellAlive();

        ArrayList<Coordinate> expectedGrid = new ArrayList<>();
        expectedGrid.add(new Coordinate(2, 1));
        expectedGrid.add(new Coordinate(2, 2));
        expectedGrid.add(new Coordinate(1, 1));
        expectedGrid.add(new Coordinate(1, 2));
        expectedGrid.sort(Comparator.comparing(Coordinate::getX));

        ArrayList<Coordinate> actual = Rules.getCoordinatesOfNextGenerationsCells(grid);
        ArrayList<Coordinate> expected = expectedGrid;

        Assert.assertEquals(expected, actual);
    }


}
