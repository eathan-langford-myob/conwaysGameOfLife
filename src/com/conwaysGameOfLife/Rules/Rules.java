package com.conwaysGameOfLife.Rules;

import com.conwaysGameOfLife.Cell;
import com.conwaysGameOfLife.Coordinate;
import com.conwaysGameOfLife.Grid;

import java.util.ArrayList;
import java.util.Arrays;

public class Rules {


    public static long getNumberOfLiveCellsFromNeighbors(Cell[] neighbors) {
        return Arrays.stream(neighbors)
                .filter(Cell::isAlive)
                .count();
    }

    public static boolean calculateCellLifeExpectancy(Cell currentCell, Cell[] neighbors) {
        long liveCellNeighborsCount = getNumberOfLiveCellsFromNeighbors(neighbors);

        return currentCell.isAlive() ?
                CellLifeRules.LIVECELL.valuesForLife(liveCellNeighborsCount) :
                CellLifeRules.DEADCELL.valuesForLife(liveCellNeighborsCount);
    }

    public static ArrayList<Coordinate> getCoordinatesOfNextGenerationsCells(Grid grid) {
        Cell[] cellNeighbors;
        Cell currentCell;
        ArrayList<Coordinate> coordinatesOfAliveCellsOnNextState = new ArrayList<>();

        for (int x = 0; x < grid.getGridWidth(); x++) {
            for (int y = 0; y < grid.getGridHeight(); y++) {
                Coordinate currentCoordinate = new Coordinate(x, y);
                currentCell = grid.getCellByCoordinate(currentCoordinate);
                cellNeighbors = grid.getNeighborsOfCell(currentCoordinate);

                if (Rules.calculateCellLifeExpectancy(currentCell, cellNeighbors)) {
                    coordinatesOfAliveCellsOnNextState.add(currentCoordinate);
                }
            }
        }
//        coordinatesOfAliveCellsOnNextState.sort(Comparator.comparing(Coordinate::getX));
        return coordinatesOfAliveCellsOnNextState;
    }
}
