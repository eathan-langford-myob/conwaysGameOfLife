package com.conwaysGameOfLife;

public enum LifeValues {
    LIVE_BIRTH(3),
    LIVE_SURVIVAL(2|3),
    DEATH_ISOLATION(1),
    DEATH_OVERCROWDING(4);

    private int cellCount;

    LifeValues(int cellCount) {
        this.cellCount = cellCount;
    }

    public int cellCount() {
        return cellCount;
    }
}
