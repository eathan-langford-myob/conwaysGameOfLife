package com.conwaysgameoflife.grid;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    public Coordinate incrementX() {
        return new Coordinate(x + 1, y);
    }

    public Coordinate incrementY() {
        return new Coordinate(x, y + 1);
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }

}
