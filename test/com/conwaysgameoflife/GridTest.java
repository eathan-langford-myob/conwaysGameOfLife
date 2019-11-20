package com.conwaysgameoflife;

import com.conwaysgameoflife.grid.Cell;
import com.conwaysgameoflife.grid.Coordinate;
import com.conwaysgameoflife.grid.Grid;
import com.conwaysgameoflife.io.ConsoleOutput;
import com.conwaysgameoflife.io.IOutput;
import com.conwaysgameoflife.render.GridRender;
import com.conwaysgameoflife.render.GridStringRender;
import org.junit.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GridTest {
Grid emptyGrid;
Grid firstRowPositionAliveGrid;
Grid propellorPatternGrid;

    @Before
    public void setUp() {
        emptyGrid = new Grid(3,5);

        firstRowPositionAliveGrid = new Grid(3,3);
        firstRowPositionAliveGrid.getCellByCoordinate(new Coordinate(0,0)).makeCellAlive();

        propellorPatternGrid = new Grid(5,5);
        propellorPatternGrid.getCellByCoordinate(new Coordinate(3,1)).makeCellAlive();
        propellorPatternGrid.getCellByCoordinate(new Coordinate(3,2)).makeCellAlive();
        propellorPatternGrid.getCellByCoordinate(new Coordinate(3,3)).makeCellAlive();
    }

    @After
    public void tearDown() {
        emptyGrid = null;
        firstRowPositionAliveGrid = null;
    }

//    @Test
//    public void shouldReturnEmptyGrid() {
//        boolean actual = emptyGrid.isEmpty();
//
//        Assert.assertTrue(actual);
//    }
//
//    @Test
//    public void shouldReturnTrue_WhenQueryingRowWithLiveCells() {
//        firstRowPositionAliveGrid = new Grid(3,3);
//        firstRowPositionAliveGrid.getCellByCoordinate(new Coordinate(0,0)).makeCellAlive();
//
//        boolean expected = firstRowPositionAliveGrid.rowHasLiveCells(new Coordinate(0,0));
//
//        Assert.assertTrue(expected);
//    }

    @Test
    public void shouldReturnFalseForIndividualCellStatus_WhenQueriedFromGrid() {
        boolean actual = emptyGrid.getCellByCoordinate(new Coordinate(1,1)).isAlive();

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnArrayOfCellsNeighbors_WhenGivenACoordinate() {
        Cell[] actual = emptyGrid.getNeighborsOfCell(new Coordinate(1,1));
        Cell[] expected = {
                emptyGrid.getCellByCoordinate(new Coordinate(0,0)),
                emptyGrid.getCellByCoordinate(new Coordinate(1,0)),
                emptyGrid.getCellByCoordinate(new Coordinate(2,0)),
                emptyGrid.getCellByCoordinate(new Coordinate(2,1)),
                emptyGrid.getCellByCoordinate(new Coordinate(2,2)),
                emptyGrid.getCellByCoordinate(new Coordinate(1,2)),
                emptyGrid.getCellByCoordinate(new Coordinate(0,2)),
                emptyGrid.getCellByCoordinate(new Coordinate(0,1)),
                };

        Assert.assertArrayEquals(expected, actual);
    }


    @Test
    public void shouldReturnArrayOfNextGenerationCoordinates_WhenGridHas3LiveCells_PropellerPattern() {
        Grid grid = new Grid(5, 5);
        grid.getCellByCoordinate(new Coordinate(2, 1)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 2)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 3)).makeCellAlive();

        ArrayList<Coordinate> expectedGrid = new ArrayList<>();
        expectedGrid.add(new Coordinate(1, 2));
        expectedGrid.add(new Coordinate(2, 2));
        expectedGrid.add(new Coordinate(3, 2));
        expectedGrid.sort(Comparator.comparing(Coordinate::getX));

        ArrayList<Coordinate> actual = grid.getCoordinatesOfNextGenerationsCells();
        ArrayList<Coordinate> expected = expectedGrid;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnArrayOfSameCoordinates_WhenGridHas4LiveCells_StillLifeBlockPattern() {
        Grid grid = new Grid(5, 5);
        grid.getCellByCoordinate(new Coordinate(2, 1)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(2, 2)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(1, 1)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(1, 2)).makeCellAlive();

        ArrayList<Coordinate> expectedGrid = new ArrayList<>();
        expectedGrid.add(new Coordinate(2, 1));
        expectedGrid.add(new Coordinate(2, 2));
        expectedGrid.add(new Coordinate(1, 1));
        expectedGrid.add(new Coordinate(1, 2));
        expectedGrid.sort(Comparator.comparing(Coordinate::getX));

        ArrayList<Coordinate> actual = grid.getCoordinatesOfNextGenerationsCells();
        ArrayList<Coordinate> expected = expectedGrid;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnNewGridWithNextGenerationCells() {
        Grid nextStateOfPropellorPattern = new Grid(5,5);
        nextStateOfPropellorPattern.getCellByCoordinate(new Coordinate(2,2)).makeCellAlive();;
        nextStateOfPropellorPattern.getCellByCoordinate(new Coordinate(3,2)).makeCellAlive();;
        nextStateOfPropellorPattern.getCellByCoordinate(new Coordinate(4,2)).makeCellAlive();;

        Grid actual = propellorPatternGrid.getNextGenerationOfGrid();
        Grid expected = nextStateOfPropellorPattern;

        Assert.assertEquals(expected, actual);
    }
}
