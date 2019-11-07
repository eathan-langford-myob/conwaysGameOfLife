package com.conwaysGameOfLife;

import java.util.Arrays;

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
}
