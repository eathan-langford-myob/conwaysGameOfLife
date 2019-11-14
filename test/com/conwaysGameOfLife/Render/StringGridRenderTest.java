package com.conwaysGameOfLife.Render;

import com.conwaysGameOfLife.Coordinate;
import com.conwaysGameOfLife.Grid;
import org.junit.*;

public class StringGridRenderTest {


    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void renderEmptyBoard() {
        GridRender boardRenderer = new GridStringRender();
        Grid emptyGrid = new Grid(5, 5);

        String actual = boardRenderer.renderGrid(emptyGrid);
        String expected =
                "  ▢  ▢  ▢  ▢  ▢\n" +
                        "  ▢  ▢  ▢  ▢  ▢\n" +
                        "  ▢  ▢  ▢  ▢  ▢\n" +
                        "  ▢  ▢  ▢  ▢  ▢\n" +
                        "  ▢  ▢  ▢  ▢  ▢\n";

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnBoardWithLiveCells_WhenPropellorPatternIsSet() {
        GridRender boardRenderer = new GridStringRender();
        Grid gridWithPropellorPattern = new Grid(5, 5);
        gridWithPropellorPattern.getCellByCoordinate(new Coordinate(2, 1)).makeCellAlive();
        gridWithPropellorPattern.getCellByCoordinate(new Coordinate(2, 2)).makeCellAlive();
        gridWithPropellorPattern.getCellByCoordinate(new Coordinate(2, 3)).makeCellAlive();


        String actual = boardRenderer.renderGrid(gridWithPropellorPattern);
        String expected =
                        "  ▢  ▢  ▢  ▢  ▢\n" +
                                "  ▢  ▢  ▣  ▢  ▢\n" +
                                "  ▢  ▢  ▣  ▢  ▢\n" +
                                "  ▢  ▢  ▣  ▢  ▢\n" +
                                "  ▢  ▢  ▢  ▢  ▢\n";

        Assert.assertEquals(expected, actual);
    }
}
