package com.conwaysGameOfLife;

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
        firstRowPositionAliveGrid.getCell(new Coordinate(0,0)).makeCellAlive();

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
        Cell[] actual = emptyGrid.getNeighborsOfCell(new Coordinate(1,1));
        Cell[] expected = {
                emptyGrid.getCell(new Coordinate(0,0)),
                emptyGrid.getCell(new Coordinate(1,0)),
                emptyGrid.getCell(new Coordinate(2,0)),
                emptyGrid.getCell(new Coordinate(2,1)),
                emptyGrid.getCell(new Coordinate(2,2)),
                emptyGrid.getCell(new Coordinate(1,2)),
                emptyGrid.getCell(new Coordinate(0,2)),
                emptyGrid.getCell(new Coordinate(0,1)),
                };

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnNextStateOfGrid_WhenGridHas3LiveCells() {
        Grid grid = new Grid(3,3);
        grid.getCell(new Coordinate(1,0)).makeCellAlive();
        grid.getCell(new Coordinate(1,1)).makeCellAlive();
        grid.getCell(new Coordinate(1,2)).makeCellAlive();

        Grid expectedGrid = new Grid(3,3);
        expectedGrid.getCell(new Coordinate(0,1)).makeCellAlive();
        expectedGrid.getCell(new Coordinate(1,1)).makeCellAlive();
        expectedGrid.getCell(new Coordinate(2,1)).makeCellAlive();

        Grid actual = grid.getNextStateOfGrid();
        Grid expected = expectedGrid;

        Assert.assertEquals(expected, actual);
    }


}
