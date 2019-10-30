package com.conwaysGameOfLife;

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
}
