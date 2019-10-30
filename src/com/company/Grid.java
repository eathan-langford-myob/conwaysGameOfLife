package com.company;

public class Grid {
    Cell[][] grid;
    int gridHeight;
    int gridWidth;

    public Grid(int height, int width) {
    this.gridHeight = height;
    this.gridWidth = width;
    this.grid = new Cell[width][height];
        for (int x = 0; x < gridWidth; x++) {
            for (int y = 0; y < gridHeight; y++) {
                grid[x][y] = new Cell();
            }
        }
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

    public Cell[] getNeighbors(Coordinate coordinate) {
        return new Cell[]{new Cell()};
    }
}
