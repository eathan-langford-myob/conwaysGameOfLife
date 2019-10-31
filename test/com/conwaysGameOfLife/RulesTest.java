package com.conwaysGameOfLife;

import org.junit.*;

public class RulesTest {
    private Grid gridWith3LiveCells;
    Cell[] neighbors;
//    live < 2 live neighbors = dead 
//    live > 3 live neighbors = dead 
//    live 2 || 3 = live
//     dead == 3 live neighbors = live
    @Before
    public void setUp() {
        gridWith3LiveCells = new Grid(3,3);
        gridWith3LiveCells.getCell(new Coordinate(1,0)).changeStatus();
        gridWith3LiveCells.getCell(new Coordinate(2,0)).changeStatus();
        gridWith3LiveCells.getCell(new Coordinate(0,2)).changeStatus();
        neighbors = gridWith3LiveCells.getNeighborsOfCell(new Coordinate(1,1));
    }

    @Test
    public void shouldReturnNumberOfLiveNeighbors_WhenQueryingRules() {
        long actual = Rules.getNumberOfLiveCellsFromNeighbors(neighbors);
        long expected = 3;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnDeadCell_WhenSurroundedBy3LiveCells() {
        Cell queriedCell = gridWith3LiveCells.getCell(new Coordinate(1,1));
        queriedCell.changeStatus();

        Cell actual = Rules.calculateCellStatus(queriedCell, neighbors);
        Cell expected = new Cell(false);

        Assert.assertEquals(expected, actual);
    }

}
