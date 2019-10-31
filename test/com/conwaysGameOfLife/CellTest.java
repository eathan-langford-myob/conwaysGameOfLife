package com.conwaysGameOfLife;


import org.junit.*;

public class CellTest {
    Cell aliveCell;

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void shouldReturnFalseState_WhenQueryingDeadCell() {
        Cell deadCell = new Cell(false);

        boolean actual = deadCell.isAlive();
        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnTrueState_WhenQueryingLiveCell() {
        Cell aliveCell = new Cell(true);

        boolean actual = aliveCell.isAlive();
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnLiveCell_WhenStatusSwitchingDeadCell() {
        Cell deadCell = new Cell(false);
        deadCell.changeStatus();
        boolean expected = deadCell.isAlive();

        Assert.assertTrue(expected);
    }
}