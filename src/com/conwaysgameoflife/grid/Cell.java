package com.conwaysgameoflife.grid;

public class Cell {
    private boolean isAlive;


    public Cell() {
        this(false);
    }

    public Cell(boolean isAlive) {
        this.isAlive = isAlive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return isAlive() == cell.isAlive();
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void makeCellAlive() {
        this.isAlive = true;
    }
}