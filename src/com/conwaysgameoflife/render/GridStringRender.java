package com.conwaysgameoflife.render;

import com.conwaysgameoflife.Cell;
import com.conwaysgameoflife.Coordinate;
import com.conwaysgameoflife.Grid;

public class GridStringRender implements GridRender {
    private StringBuilder parsedBoard = new StringBuilder();


    @Override
    public String renderGrid(Grid grid) {
        for (int y = 0; y < grid.getGridHeight(); y++) {
            for (int x = 0; x < grid.getGridWidth(); x++) {
                Coordinate currentCoordinate = new Coordinate(x, y);
                Cell currentCell = grid.getCellByCoordinate(currentCoordinate);
                parseCellToString(currentCell);
            }
            parsedBoard.append("\n");
        }
        return parsedBoard.toString();
    }

    private void parseCellToString(Cell currentCell) {
        gridSymbols calculateCellToString = currentCell.isAlive() ? gridSymbols.LIVECELL : gridSymbols.DEADCELL;

        parsedBoard.append(gridSymbols.SPACE.value);
        parsedBoard.append(calculateCellToString.value);
    }

}