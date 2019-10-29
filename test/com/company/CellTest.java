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
    public void shouldReturnFalse_WhenQueryingDeadCell() {
        Cell deadCell = new Cell(false);

        boolean actual = deadCell.isAlive();
        Assert.assertTrue(actual);
    }


}
