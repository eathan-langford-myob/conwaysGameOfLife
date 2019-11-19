package com.conwaysgameoflife;

import java.util.Objects;

public class Cell {
    private boolean isAlive;

    public Cell() {
        this.isAlive = false;
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

    @Override
    public int hashCode() {
        return Objects.hash(isAlive());
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void makeCellAlive() {
        this.isAlive = true;
    }
}