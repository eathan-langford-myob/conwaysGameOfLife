package com.company;

import org.junit.*;

import static org.junit.Assert.*;

public class GridTest {
    Grid emptyGrid;

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldReturnEmptyGrid() {
        emptyGrid = new Grid();

        boolean actual = emptyGrid.isEmpty();
        Assert.assertTrue(actual);
    }
}
