package com.conwaysgameoflife.grid;

import com.conwaysgameoflife.rules.CellRules;

import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private Cell[][] grid;
    private int gridHeight;
    private int gridWidth;

    public Grid(int width, int height) {
        this.gridHeight = height;
        this.gridWidth = width;
        this.grid = new Cell[width][height];
        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                grid[x][y] = new Cell();
            }
        }
    }

    public void setLiveCells(ArrayList<Coordinate> coordinatesOfLiveCells) {
        for (Coordinate coordinate : coordinatesOfLiveCells) {
            getCellByCoordinate(coordinate).makeCellAlive();
        }
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

//    public boolean rowHasLiveCells(Coordinate coordinates) {
//        if (coordinates.getX() <= gridWidth - 1) {
//            Cell currentCell = getCellByCoordinate(coordinates);
//            if (currentCell.isAlive()) {
//                return true;
//            }
//            rowHasLiveCells(coordinates.incrementX());
//        }
//        return false;
//    }
//
//    public boolean isEmpty() {
//        for (int y = 1; y < gridHeight; y++) {
//            if (rowHasLiveCells(new Coordinate(0, y))) {
//                return false;
//            }
//        }
//        return true;
//    }

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
        // package for cell and grid - done
        // maybe split into grid thing that deals with getting and setting grid behaviour or put all into grid
        ArrayList<Coordinate> nextGridConfiguration = getCoordinatesOfNextGenerationsCells();
        Grid nextGenerationGrid = new Grid(getGridWidth(), getGridHeight());
        nextGenerationGrid.setLiveCells(nextGridConfiguration);

        return nextGenerationGrid;
    }
}
