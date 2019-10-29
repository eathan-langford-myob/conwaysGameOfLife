package com.company;


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
        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrueState_WhenQueryingLiveCell() {
        Cell aliveCell = new Cell(true);

        boolean actual = aliveCell.isAlive();
        Assert.assertTrue(actual);
    }

}
