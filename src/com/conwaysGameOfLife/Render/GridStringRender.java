package com.conwaysGameOfLife.Render;

import com.conwaysGameOfLife.Cell;
import com.conwaysGameOfLife.Coordinate;
import com.conwaysGameOfLife.Grid;

public class GridStringRender implements GridRender {
    private StringBuilder parsedBoard = new StringBuilder();


    @Override
    public String renderGrid(Grid grid) {
        for (int y = 0; y < grid.getGridHeight(); y++) {
            for (int x = 0; x < grid.getGridWidth(); x++) {
                Coordinate currentCoordinate = new Coordinate(x, y);
                Cell currentCell = grid.getCell(currentCoordinate);
                parseCellToString(currentCell);
            }
            parsedBoard.append("\n");
        }
        return parsedBoard.toString();
    }

    private void parseCellToString(Cell currentCell) {
        if (currentCell.isAlive()) {
            parsedBoard.append(gridSymbols.LIVECELL.picture);
        } else {
            parsedBoard.append(gridSymbols.DEADCELL.picture);
        }
    }

}
