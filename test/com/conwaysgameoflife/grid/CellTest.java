package com.conwaysgameoflife.grid;


import org.junit.Assert;
import org.junit.Test;

public class CellTest {
    private Cell cell;

    @Test
    public void shouldReturnFalseState_WhenQueryingDeadCell() {
        this.cell = new Cell(false);

        boolean actual = this.cell.isAlive();
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueState_WhenQueryingLiveCell() {
        this.cell = new Cell(true);

        boolean actual = this.cell.isAlive();
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenMakingDeadCellAlive() {
        this.cell = new Cell(false);

        this.cell.makeCellAlive();
        boolean expected = this.cell.isAlive();

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnTrue_WhenComparingEqualCells() {
        this.cell = new Cell(true);

        Cell secondLiveCell = new Cell(true);

        Assert.assertEquals(this.cell, secondLiveCell);
    }
}