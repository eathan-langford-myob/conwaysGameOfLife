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
        grid.getCell(new Coordinate(1,0)).changeStatus();
        grid.getCell(new Coordinate(2,0)).changeStatus();
        grid.getCell(new Coordinate(0,2)).changeStatus();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));

        long actual = Rules.getNumberOfLiveCellsFromNeighbors(neighbors);
        long expected = 3;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy3LiveCells() {
        grid.getCell(new Coordinate(1,0)).changeStatus();
        grid.getCell(new Coordinate(2,2)).changeStatus();
        grid.getCell(new Coordinate(1,2)).changeStatus();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));

        Cell actual = Rules.calculateCellStatus(queriedCell, neighbors);
        Cell expected = new Cell(true);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenSurroundedBy2LiveCells() {
        grid.getCell(new Coordinate(1,0)).changeStatus();
        grid.getCell(new Coordinate(2,0)).changeStatus();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));
        queriedCell.changeStatus();

        Cell actual = Rules.calculateCellStatus(queriedCell, neighbors);
        Cell expected = new Cell(true);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeadCell_WhenSurroundedBy4LiveCells() {
        grid.getCell(new Coordinate(1,0)).changeStatus();
        grid.getCell(new Coordinate(2,0)).changeStatus();
        grid.getCell(new Coordinate(2,2)).changeStatus();
        grid.getCell(new Coordinate(0,1)).changeStatus();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));
        queriedCell.changeStatus();

        Cell actual = Rules.calculateCellStatus(queriedCell, neighbors);
        Cell expected = new Cell(false);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeadCell_WhenSurroundedByLessThan3LiveCells() {
        grid.getCell(new Coordinate(1,0)).changeStatus();
        neighbors = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell queriedCell = grid.getCell(new Coordinate(1,1));
        queriedCell.changeStatus();

        Cell actual = Rules.calculateCellStatus(queriedCell, neighbors);
        Cell expected = new Cell(false);

        Assert.assertEquals(expected, actual);
    }
//    live < 2 live neighbors = dead 
//    live > 3 live neighbors = dead 
//    live 2 || 3 = live
//     dead == 3 live neighbors = live
}
