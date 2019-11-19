package com.conwaysgameoflife.rulesofcellbehaviour;

public enum CellLifeRules {
    LIVECELL {
        @Override
        public boolean valuesForLife(long numberOfNeighbors) {
            return numberOfNeighbors == 2 || numberOfNeighbors == 3;
        }
    },
    DEADCELL() {
        @Override
        public boolean valuesForLife(long numberOfNeighbors) {
            return numberOfNeighbors == 3;
        }
    };

    public abstract boolean valuesForLife(long numberOfNeighbors);

}
