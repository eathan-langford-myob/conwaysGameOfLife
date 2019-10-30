package com.conwaysGameOfLife;

import org.junit.*;

public class RulesTest {
//    live < 2 live neighbors = dead 
//    live > 3 live neighbors = dead 
//    live 2 || 3 = live
//     dead == 3 live neighbors = live
    @Test
    public void shouldReturnNumberOfLiveNeighbors_WhenQueryingRules() {
        Grid gridWith3LiveCells;
        Cell[] neighbors = {new Cell()};
        int actual = Rules.getNumberOfLiveCellsFromNeighbors(neighbors);
        int expected = 3;

        Assert.assertEquals(expected, actual);
    }

}
