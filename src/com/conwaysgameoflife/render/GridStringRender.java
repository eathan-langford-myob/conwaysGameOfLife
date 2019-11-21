package com.conwaysgameoflife.render;

import com.conwaysgameoflife.grid.Cell;
import com.conwaysgameoflife.grid.Coordinate;
import com.conwaysgameoflife.grid.Grid;

public class GridStringRender implements GridRender {
    private StringBuilder parsedBoard;


    @Override
    public String renderGrid(Grid grid) {
        parsedBoard = new StringBuilder();
        for (int y = 0; y < grid.getGridHeight(); y++) {
            for (int x = 0; x < grid.getGridWidth(); x++) {
                Cell currentCell = grid.getCellByCoordinate(new Coordinate(x, y));
                parseCellToString(currentCell);
                parsedBoard.append(GridSymbols.SPACE.value);

            }
            parsedBoard.append("\n");
        }
        return parsedBoard.toString();
    }

    private void parseCellToString(Cell currentCell) {
        GridSymbols calculateCellToString = currentCell.isAlive() ? GridSymbols.LIVECELL : GridSymbols.DEADCELL;
        parsedBoard.append(calculateCellToString.value);
    }

}
