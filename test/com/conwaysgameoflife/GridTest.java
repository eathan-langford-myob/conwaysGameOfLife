package com.conwaysgameoflife;

import org.junit.*;

public class GridTest {
Grid emptyGrid;
Grid firstRowPositionAliveGrid;

    @Before
    public void setUp() {
        emptyGrid = new Grid(3,5);
        firstRowPositionAliveGrid = new Grid(3,3);
        firstRowPositionAliveGrid.getCellByCoordinate(new Coordinate(0,0)).makeCellAlive();
    }

    @After
    public void tearDown() {
        emptyGrid = null;
        firstRowPositionAliveGrid = null;
    }

    @Test
    public void shouldReturnEmptyGrid() {
        boolean actual = emptyGrid.isEmpty();

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenQueryingRowWithLiveCells() {
        firstRowPositionAliveGrid = new Grid(3,3);
        firstRowPositionAliveGrid.getCellByCoordinate(new Coordinate(0,0)).makeCellAlive();

        boolean expected = firstRowPositionAliveGrid.rowHasLiveCells(new Coordinate(0,0));

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnFalseForIndividualCellStatus_WhenQueriedFromGrid() {
        boolean actual = emptyGrid.getCellByCoordinate(new Coordinate(1,1)).isAlive();

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnArrayOfCellsNeighbors_WhenGivenACoordinate() {
        Cell[] actual = emptyGrid.getNeighborsOfCell(new Coordinate(1,1));
        Cell[] expected = {
                emptyGrid.getCellByCoordinate(new Coordinate(0,0)),
                emptyGrid.getCellByCoordinate(new Coordinate(1,0)),
                emptyGrid.getCellByCoordinate(new Coordinate(2,0)),
                emptyGrid.getCellByCoordinate(new Coordinate(2,1)),
                emptyGrid.getCellByCoordinate(new Coordinate(2,2)),
                emptyGrid.getCellByCoordinate(new Coordinate(1,2)),
                emptyGrid.getCellByCoordinate(new Coordinate(0,2)),
                emptyGrid.getCellByCoordinate(new Coordinate(0,1)),
                };

        Assert.assertArrayEquals(expected, actual);
    }

//    @Test
//    public void shouldMakeBoardEmpty_WhenClearingBoard() {
//        firstRowPositionAliveGrid.clear();
//        boolean expected = firstRowPositionAliveGrid.isEmpty();
//
//        Assert.assertTrue(expected);
//    }
}
