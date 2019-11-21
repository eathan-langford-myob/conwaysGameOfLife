package com.conwaysgameoflife.render;

import com.conwaysgameoflife.grid.Coordinate;
import com.conwaysgameoflife.grid.Grid;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StringGridRenderTest {
    private Grid grid;
    private GridRender boardRenderer;

    @Before
    public void setUp() {
        grid = new Grid(5,5);
        boardRenderer = new GridStringRender();
    }

    @After
    public void tearDown() {
        grid = null;
        boardRenderer = null;
    }
    @Test
    public void renderEmptyGrid() {
        String actual = boardRenderer.renderGrid(grid);
        String expected =
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnBoardWithLiveCells_WhenPropellorPatternIsSet() {
        grid.getCellByCoordinate(new Coordinate(2, 1)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 2)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 3)).makeCellAlive();


        String actual = boardRenderer.renderGrid(grid);
        String expected =
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n";

        Assert.assertEquals(expected, actual);
    }
}
