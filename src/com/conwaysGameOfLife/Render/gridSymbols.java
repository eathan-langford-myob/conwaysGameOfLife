package com.conwaysGameOfLife.Render;

public enum gridSymbols {
    DEADCELL("  "+"\u25A2"),
    LIVECELL("  "+"\u25A3");
//    TOPLEFT(),
//    TOP(),
//    TOPRIGHT(),
//    RIGHT(),
//    BOTTOMRIGHT(),
//    BOTTOM(),
//    BOTTOMLEFT(),
//    LEFT(),


    String picture;

    gridSymbols(String picture) {
        this.picture = picture;
    }
}
