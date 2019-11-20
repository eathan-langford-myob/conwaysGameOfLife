package com.conwaysgameoflife.rules;

public enum CellLifeRules {
    LIVECELL {
        @Override
        public boolean isCellAliveNextGen(long numberOfNeighbors) {
            return numberOfNeighbors == 2 || numberOfNeighbors == 3;
        }
    },
    DEADCELL() {
        @Override
        public boolean isCellAliveNextGen(long numberOfNeighbors) {
            return numberOfNeighbors == 3;
        }
    };

    public abstract boolean isCellAliveNextGen(long numberOfNeighbors);

}
