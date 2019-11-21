package com.conwaysgameoflife.rules;

import com.conwaysgameoflife.grid.Cell;
import com.conwaysgameoflife.grid.Coordinate;
import com.conwaysgameoflife.grid.Grid;
import org.junit.*;

public class RulesTest {
    private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(3, 3);
    }

    @After
    public void tearDown() {
        grid = null;
    }

    @Test
    public void shouldReturnNumberOfLiveNeighbors_WhenCheckingSingleCell() {
        grid.getCellByCoordinate(new Coordinate(1, 0)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 0)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(0, 2)).makeCellAlive();
        Cell[] neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));

        long actual = CellRules.getNumberOfLiveCellsFromNeighbors(neighbors);
        long expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy3LiveCells() {
        grid.getCellByCoordinate(new Coordinate(1, 0)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 2)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(1, 2)).makeCellAlive();
        Cell[] neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCellByCoordinate(new Coordinate(1, 1));

        boolean actual = CellRules.willCellBeAlive(queriedCell, neighbors);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy2LiveCells() {
        grid.getCellByCoordinate(new Coordinate(1, 0)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 0)).makeCellAlive();
        Cell[] neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCellByCoordinate(new Coordinate(1, 1));
        queriedCell.makeCellAlive();

        boolean actual = CellRules.willCellBeAlive(queriedCell, neighbors);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnDeadCell_WhenSurroundedBy4LiveCells() {
        grid.getCellByCoordinate(new Coordinate(1, 0)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 0)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 2)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(0, 1)).makeCellAlive();
        Cell[] neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCellByCoordinate(new Coordinate(1, 1));
        queriedCell.makeCellAlive();

        boolean actual = CellRules.willCellBeAlive(queriedCell, neighbors);

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnFalse_WhenSurroundedByLessThan3LiveCells() {
        grid.getCellByCoordinate(new Coordinate(1, 0)).makeCellAlive();
        Cell[] neighbors = grid.getNeighborsOfCell(new Coordinate(1, 1));
        Cell queriedCell = grid.getCellByCoordinate(new Coordinate(1, 1));
        queriedCell.makeCellAlive();

        boolean actual = CellRules.willCellBeAlive(queriedCell, neighbors);

        Assert.assertFalse(actual);
    }
}
