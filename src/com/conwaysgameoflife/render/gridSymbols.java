package com.conwaysgameoflife.render;

public enum gridSymbols {
    DEADCELL("\u25A2"),
    LIVECELL("\u25A3"),
    SPACE("  ");


    String value;

    gridSymbols(String value) {
        this.value = value;
    }
}
