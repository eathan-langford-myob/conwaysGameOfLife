package com.conwaysgameoflife;


import com.conwaysgameoflife.grid.Cell;
import org.junit.*;

public class CellTest {
    Cell aliveCell;
    Cell deadCell;


    @Before
    public void setUp() {
        aliveCell = new Cell(true);
        deadCell = new Cell(false);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void shouldReturnFalseState_WhenQueryingDeadCell() {

        boolean actual = deadCell.isAlive();
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueState_WhenQueryingLiveCell() {
        boolean actual = aliveCell.isAlive();
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenStatusSwitchingDeadCell() {
        deadCell.makeCellAlive();
        boolean expected = deadCell.isAlive();

        Assert.assertTrue(expected);
    }

    @Test
    public void shouldReturnTrueForEqualCells() {
        Cell secondLiveCell = new Cell(true);

        Assert.assertEquals(aliveCell, secondLiveCell);
    }
}