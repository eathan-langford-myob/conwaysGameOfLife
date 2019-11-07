package com.conwaysGameOfLife;

import java.util.Arrays;

public class Rules {
    public static long getNumberOfLiveCellsFromNeighbors(Cell[] neighbors) {
        return Arrays.stream(neighbors).filter(Cell::isAlive).count();
    }

    public static boolean calculateCellsNextLife(Cell currentCell, Cell[] neighbors) {
            long liveCellNeighborsCount = getNumberOfLiveCellsFromNeighbors(neighbors);
            return currentCell.isAlive() ? liveCellNeighborsCount == 2 || liveCellNeighborsCount == 3 : liveCellNeighborsCount == 3;
    }
}
