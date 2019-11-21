package com.conwaysgameoflife.grid;

import com.conwaysgameoflife.rules.CellRules;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private Cell[][] grid;
    private int gridHeight;
    private int gridWidth;

    public Grid(int width, int height, ArrayList<Coordinate> coordinatesOfCells) {
        this.gridHeight = height;
        this.gridWidth = width;
        this.grid = new Cell[width][height];
        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                if (!coordinatesOfCells.isEmpty() && coordinatesOfCells.contains(new Coordinate(x, y))) {
                    grid[x][y] = new Cell();
                    grid[x][y].makeCellAlive();
                } else {
                    grid[x][y] = new Cell();
                }
            }
        }
    }

    public Grid(int width, int height) {
        this(width, height, new ArrayList<>(1));
    }

    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public Cell getCellByCoordinate(Coordinate coordinate) {
        return grid[coordinate.getX()][coordinate.getY()];
    }

    public Cell[] getNeighborsOfCell(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int left = (x - 1 + gridWidth) % gridWidth;
        int right = (x + 1) % gridWidth;
        int up = (y - 1 + gridHeight) % gridHeight;
        int down = (y + 1) % gridHeight;


        return new Cell[]{
                getCellByCoordinate(new Coordinate(left, up)),
                getCellByCoordinate(new Coordinate(x, up)),
                getCellByCoordinate(new Coordinate(right, up)),
                getCellByCoordinate(new Coordinate(right, y)),
                getCellByCoordinate(new Coordinate(right, down)),
                getCellByCoordinate(new Coordinate(x, down)),
                getCellByCoordinate(new Coordinate(left, down)),
                getCellByCoordinate(new Coordinate(left, y))
        };
    }

    public ArrayList<Coordinate> getCoordinatesOfNextGenerationsCells() {
        Cell[] cellNeighbors;
        Cell currentCell;
        ArrayList<Coordinate> coordinatesOfAliveCellsOnNextState = new ArrayList<>();

        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                Coordinate currentCoordinate = new Coordinate(x, y);
                currentCell = getCellByCoordinate(currentCoordinate);
                cellNeighbors = getNeighborsOfCell(currentCoordinate);

                if (CellRules.willCellBeAlive(currentCell, cellNeighbors)) {
                    coordinatesOfAliveCellsOnNextState.add(currentCoordinate);
                }
            }
        }
        return coordinatesOfAliveCellsOnNextState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.deepEquals(this.grid, grid1.grid);
    }

    public Grid getNextGenerationOfGrid() {
        ArrayList<Coordinate> nextGridConfiguration = getCoordinatesOfNextGenerationsCells();
        return new Grid(getGridWidth(), getGridHeight(), nextGridConfiguration);
    }
}
