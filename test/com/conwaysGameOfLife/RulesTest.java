package com.conwaysGameOfLife;

import org.junit.*;

public class RulesTest {
    private Grid grid;
    Cell[] neighbors;

    @Before
    public void setUp() {
        grid = new Grid(3,3);
    }

    @Test
    public void shouldReturnNumberOfLiveNeighbors_WhenQueryingRules() {
        grid.getCell(new Coordinate(1,0)).makeCellAlive();
        grid.getCell(new Coordinate(2,0)).makeCellAlive();
        grid.getCell(new Coordinate(0,2)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));

        long actual = Rules.getNumberOfLiveCellsFromNeighbors(neighbors);
        long expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy3LiveCells() {
        grid.getCell(new Coordinate(1,0)).makeCellAlive();
        grid.getCell(new Coordinate(2,2)).makeCellAlive();
        grid.getCell(new Coordinate(1,2)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));

        boolean actual = Rules.calculateCellsNextLife(queriedCell, neighbors);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy2LiveCells() {
        grid.getCell(new Coordinate(1,0)).makeCellAlive();
        grid.getCell(new Coordinate(2,0)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));
        queriedCell.makeCellAlive();

        boolean actual = Rules.calculateCellsNextLife(queriedCell, neighbors);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnDeadCell_WhenSurroundedBy4LiveCells() {
        grid.getCell(new Coordinate(1,0)).makeCellAlive();
        grid.getCell(new Coordinate(2,0)).makeCellAlive();
        grid.getCell(new Coordinate(2,2)).makeCellAlive();
        grid.getCell(new Coordinate(0,1)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));
        queriedCell.makeCellAlive();

        boolean actual = Rules.calculateCellsNextLife(queriedCell, neighbors);

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnFalse_WhenSurroundedByLessThan3LiveCells() {
        grid.getCell(new Coordinate(1,0)).makeCellAlive();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));
        queriedCell.makeCellAlive();

        boolean actual = Rules.calculateCellsNextLife(queriedCell, neighbors);

        Assert.assertFalse(actual);
    }
//    live < 2 live neighbors = dead 
//    live > 3 live neighbors = dead 
//    live 2 || 3 = live
//     dead == 3 live neighbors = live
}
