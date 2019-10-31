package com.conwaysGameOfLife;

import java.util.Arrays;

import static com.conwaysGameOfLife.LifeValues.*;

public class Rules {
    public static long getNumberOfLiveCellsFromNeighbors(Cell[] neighbors) {
        return Arrays.stream(neighbors).filter(Cell::isAlive).count();
    }

    public static Cell calculateCellStatus(Cell currentCell, Cell[] neighbors) {
        return currentCell;
    }
}
