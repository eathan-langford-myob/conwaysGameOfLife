package com.conwaysgameoflife.rulesofcellbehaviour;

import com.conwaysgameoflife.Cell;
import com.conwaysgameoflife.Coordinate;
import com.conwaysgameoflife.Grid;

import java.util.ArrayList;
import java.util.Arrays;

public class CellLifeRulesCalculator {


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

                if (CellLifeRulesCalculator.calculateCellLifeExpectancy(currentCell, cellNeighbors)) {
                    coordinatesOfAliveCellsOnNextState.add(currentCoordinate);
                }
            }
        }
        return coordinatesOfAliveCellsOnNextState;
    }
}
