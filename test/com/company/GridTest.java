package com.company;

import org.junit.*;

public class GridTest {
Grid emptyGrid;
Grid firstRowPositionAliveGrid;

    @Before
    public void setUp() {
        emptyGrid = new Grid(3,5);

    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldReturnEmptyGrid() {
        boolean actual = emptyGrid.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenQueryingRowWithLiveCells() {
        firstRowPositionAliveGrid = new Grid(3,3);
        firstRowPositionAliveGrid.getCell(new Coordinate(0,0)).makeAlive();

        boolean expected = firstRowPositionAliveGrid.rowHasLiveCells(new Coordinate(0,0));

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnFalseForIndividualCellStatus_WhenQueriedFromGrid() {
        boolean actual = emptyGrid.getCell(new Coordinate(1,1)).isAlive();

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnArrayOfCellsNeighbors_WhenGivenACoordinate() {
        Cell[] actual = emptyGrid.getNeighbors(new Coordinate(1,1));
        Cell[] expected = { new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell(), new Cell() };

        Assert.assertArrayEquals(expected, actual);
    }
}
