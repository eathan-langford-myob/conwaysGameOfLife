package com.conwaysgameoflife.render;

public enum GridSymbols {
    DEADCELL("\u25A2"),
    LIVECELL("\u25A3"),
    SPACE("  ");


    String value;

    GridSymbols(String value) {
        this.value = value;
    }
}
