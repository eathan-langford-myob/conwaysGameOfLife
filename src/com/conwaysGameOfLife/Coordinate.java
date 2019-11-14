package com.conwaysGameOfLife;

import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Coordinate(Coordinate coordinate) {
        this.x = coordinate.getX();
        this.y = coordinate.getY();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return getX() == that.getX() &&
                getY() == that.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
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
