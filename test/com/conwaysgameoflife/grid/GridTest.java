package com.conwaysgameoflife.grid;

import org.junit.*;
import java.util.ArrayList;
import java.util.Comparator;

public class GridTest {
private Grid grid;

    @Before
    public void setUp() {
        grid = new Grid(5,5);
    }

    @After
    public void tearDown() {
        grid = null;
    }

    private boolean isEmpty(Grid grid) {
        for (int x = 0; x < grid.getGridWidth(); x++) {
            for (int y = 0; y < grid.getGridHeight(); y++) {
                if (grid.getCellByCoordinate(new Coordinate(x, y)).isAlive()) {
                    return false;
                }
            }
        }
            return true;
    }

    @Test
    public void shouldReturnTrueForEmptyGrid_WhenInitialised() {
        boolean actual = isEmpty(grid);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnFalseForEmptyGrid_WhenLiveCellExists() {
        grid.getCellByCoordinate(new Coordinate(2,2)).makeCellAlive();
        boolean actual = isEmpty(grid);

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnFalseCellStatus_WhenCheckingDeadCell() {
        boolean actual = grid.getCellByCoordinate(new Coordinate(1,1)).isAlive();

        Assert.assertFalse(actual);
    }

    @Test
    public void shouldReturnArrayOfCellsNeighbors_WhenGivenACoordinate() {
        Cell[] actual = grid.getNeighborsOfCell(new Coordinate(1,1));
        Cell[] expected = {
                grid.getCellByCoordinate(new Coordinate(0,0)),
                grid.getCellByCoordinate(new Coordinate(1,0)),
                grid.getCellByCoordinate(new Coordinate(2,0)),
                grid.getCellByCoordinate(new Coordinate(2,1)),
                grid.getCellByCoordinate(new Coordinate(2,2)),
                grid.getCellByCoordinate(new Coordinate(1,2)),
                grid.getCellByCoordinate(new Coordinate(0,2)),
                grid.getCellByCoordinate(new Coordinate(0,1)),
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

        Assert.assertEquals(expectedGrid, actual);
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

        Assert.assertEquals(expectedGrid, actual);
    }

    @Test
    public void shouldReturnNewGridWithNextGenerationCells() {
        grid = new Grid(5,5);
        grid.getCellByCoordinate(new Coordinate(3,1)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(3,2)).makeCellAlive();
        grid.getCellByCoordinate(new Coordinate(3,3)).makeCellAlive();

        Grid expectedGrid = new Grid(5,5);
        expectedGrid.getCellByCoordinate(new Coordinate(2,2)).makeCellAlive();
        expectedGrid.getCellByCoordinate(new Coordinate(3,2)).makeCellAlive();
        expectedGrid.getCellByCoordinate(new Coordinate(4,2)).makeCellAlive();

        Grid actual = grid.getNextGenerationOfGrid();

        Assert.assertEquals(expectedGrid, actual);
    }
}
