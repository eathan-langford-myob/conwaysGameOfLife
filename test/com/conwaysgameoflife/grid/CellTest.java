package com.conwaysgameoflife.grid;


import org.junit.Assert;
import org.junit.Test;

public class CellTest {
    private Cell cell;

    @Test
    public void shouldReturnFalseState_WhenQueryingDeadCell() {
        cell = new Cell(false);

        boolean actual = cell.isAlive();
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueState_WhenQueryingLiveCell() {
        cell = new Cell(true);

        boolean actual = cell.isAlive();
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenMakingDeadCellAlive() {
        cell = new Cell(false);

        cell.makeCellAlive();
        boolean expected = cell.isAlive();

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnTrue_WhenComparingEqualCells() {
        cell = new Cell(true);

        Cell secondLiveCell = new Cell(true);

        Assert.assertEquals(cell, secondLiveCell);
    }
}