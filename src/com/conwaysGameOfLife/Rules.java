package com.conwaysGameOfLife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Rules {
    private static int[] liveCellNeighborsToLive = {2,3};
    private static int deadCellNeighborsToLive = 3;

    public static long getNumberOfLiveCellsFromNeighbors(Cell[] neighbors) {
        return Arrays.stream(neighbors).filter(Cell::isAlive).count();
    }

    public static boolean calculateCellLifeExpectancy(Cell currentCell, Cell[] neighbors) {
            long liveCellNeighborsCount = getNumberOfLiveCellsFromNeighbors(neighbors);

            return currentCell.isAlive() ?
                    liveCellNeighborsCount == liveCellNeighborsToLive[0] || liveCellNeighborsCount == liveCellNeighborsToLive[1] :
                    liveCellNeighborsCount == deadCellNeighborsToLive;
    }

    public static ArrayList<Coordinate> getCoordinatesOfNextGenerationsCells(Grid grid) {
        Cell[] cellNeighbors;
        Cell currentCell;
        ArrayList<Coordinate> coordinatesOfAliveCellsOnNextState = new ArrayList<>();

        for (int x = 0; x < grid.getGridWidth(); x++) {
            for (int y = 0; y < grid.getGridHeight(); y++) {
                Coordinate currentCoordinate = new Coordinate(x,y);
                currentCell = grid.getCell(currentCoordinate);
                cellNeighbors = grid.getNeighborsOfCell(currentCoordinate);

                if (Rules.calculateCellLifeExpectancy(currentCell, cellNeighbors)) {
                    coordinatesOfAliveCellsOnNextState.add(currentCoordinate);
                }
            }
        }
        coordinatesOfAliveCellsOnNextState.sort(Comparator.comparing(Coordinate::getX));
        return coordinatesOfAliveCellsOnNextState;
    }

    public static Grid tick(Grid grid) {
        return new Grid(grid.getGridWidth(), grid.getGridHeight());
    }
}
