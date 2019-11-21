package com.conwaysgameoflife.rules;

import com.conwaysgameoflife.grid.Cell;

import java.util.Arrays;

public class CellRules {


    public static long getNumberOfLiveCellsFromNeighbors(Cell[] neighbors) {
        return Arrays.stream(neighbors)
                .filter(Cell::isAlive)
                .count();
    }

    public static boolean willCellBeAlive(Cell currentCell, Cell[] neighbors) {
        long liveCellNeighborsCount = getNumberOfLiveCellsFromNeighbors(neighbors);

        return currentCell.isAlive() ?
                CellLifeNextGenRules.ALIVECELL.isCellAliveNextGen(liveCellNeighborsCount) :
                CellLifeNextGenRules.DEADCELL.isCellAliveNextGen(liveCellNeighborsCount);
    }
}
