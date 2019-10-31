package com.conwaysGameOfLife;

import java.util.Arrays;

import static com.conwaysGameOfLife.LifeValues.*;

public class Rules {
    public static long getNumberOfLiveCellsFromNeighbors(Cell[] neighbors) {
        return Arrays.stream(neighbors).filter(Cell::isAlive).count();
    }

    public static Cell calculateCellStatus(Cell currentCell, Cell[] neighbors) {
        long liveCellNeighborsCount = getNumberOfLiveCellsFromNeighbors(neighbors);

        if (currentCell.isAlive()) {
            if (liveCellNeighborsCount <= DEATH_ISOLATION.cellCount() || liveCellNeighborsCount >= DEATH_OVERCROWDING.cellCount() || liveCellNeighborsCount == LIVE_SURVIVAL.cellCount()) {
                currentCell.changeStatus();
                return currentCell;
            }
        } else if (liveCellNeighborsCount == LIVE_BIRTH.cellCount()) {
                currentCell.changeStatus();
                return currentCell;
            }
        return currentCell;
    }
}
