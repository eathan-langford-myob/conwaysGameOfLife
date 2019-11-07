package com.conwaysGameOfLife;

import java.util.Arrays;
import java.util.Objects;

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

        public Cell[][] setLiveCells(Coordinate[] coordinatesOfLiveCells) {
        for (Coordinate coordinate : coordinatesOfLiveCells) {
            getCell(coordinate).makeCellAlive();
        }
        return grid;
    }
    //keep seperate, run it in factory method. cheers ryan
    //method to setLiveCells(pass it live cell array)
    // go through grid



    public int getGridHeight() {
        return gridHeight;
    }

    public int getGridWidth() {
        return gridWidth;
    }

    public Cell getCell(Coordinate coordinate) {
        return grid[coordinate.getX()][coordinate.getY()];
    }

    public boolean rowHasLiveCells(Coordinate coordinates) {
        if (coordinates.getX() <= gridWidth-1){
            Cell currentCell = getCell(coordinates);
            if (currentCell.isAlive()){
                return true;
            }
            rowHasLiveCells(coordinates.incrementX());
        }
        return false;
    }

    public boolean isEmpty() {
        for (int y = 1; y < gridHeight; y++) {
            if (rowHasLiveCells(new Coordinate(0,y))) {
                return false;
            }
        }
        return true;
    }
    private Cell[][] getGrid() {
        return grid;
    }

    public Cell[] getNeighborsOfCell(Coordinate coordinate) {
        int x = coordinate.getX();
        int y = coordinate.getY();
        int left = (x - 1 + gridWidth) % gridWidth;
        int right = (x + 1) % gridWidth;
        int up = (y - 1 + gridHeight) % gridHeight;
        int down = (y + 1) % gridHeight;


        return new Cell[]{
                getCell(new Coordinate(left, up)),
                getCell(new Coordinate(x, up)),
                getCell(new Coordinate(right, up)),
                getCell(new Coordinate(right, y)),
                getCell(new Coordinate(right, down)),
                getCell(new Coordinate(x, down)),
                getCell(new Coordinate(left, down)),
                getCell(new Coordinate(left, y))
        };
    }

    public Grid getNextStateOfGrid() {
        Grid newGrid = new Grid(getGridWidth(), getGridHeight());
        newGrid.getCell(new Coordinate(0,1)).makeCellAlive();
        newGrid.getCell(new Coordinate(1,1)).makeCellAlive();
        newGrid.getCell(new Coordinate(2,1)).makeCellAlive();
        //loop
        //get cell by coord
        //check cell neighbors
        //add coord to array
        //apply array to new board
        //return new board
        return newGrid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.deepEquals(this.grid, grid1.grid);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getGridHeight(), getGridWidth());
        result = 31 * result + Arrays.hashCode(getGrid());
        return result;
    }
}
