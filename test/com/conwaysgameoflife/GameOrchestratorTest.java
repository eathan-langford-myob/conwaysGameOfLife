package com.conwaysgameoflife;

import com.conwaysgameoflife.io.ConsoleInput_Mock;
import com.conwaysgameoflife.io.ConsoleOutput_Mock;
import com.conwaysgameoflife.io.IInput;
import com.conwaysgameoflife.io.InputParser;
import com.conwaysgameoflife.render.GridRender;
import com.conwaysgameoflife.render.GridStringRender;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;


public class GameOrchestratorTest {
    private GameOrchestrator game;
    private IInput input;
    private ConsoleOutput_Mock output;
    private GridRender renderer;
    private InputParser parser;
    private ArrayList<String> mockInput;


    @Before
    public void setUp() {
        mockInput = new ArrayList<>();
        mockInput.add("5");
        mockInput.add("5");
        mockInput.add("2,1/2,2/2,3");
        mockInput.add("2");


        input = new ConsoleInput_Mock(mockInput);
        output = new ConsoleOutput_Mock();
        renderer = new GridStringRender();
        parser = new InputParser();
        game = new GameOrchestrator(input, output, renderer, parser);
    }

    @After
    public void tearDown() {
        game = null;
        input = null;
        output = null;
        renderer = null;
        parser = null;
        mockInput = null;
    }

    @Test
    public void gameRunsToCompletion() {
        ArrayList<String> expectedGameMessages = new ArrayList<>(Arrays.asList(
                "Welcome to Conway's Game of Life!",
                "The rules are as followed:",
                "Any live cell with fewer than two live neighbours dies",
                "as if caused by underpopulation.",
                "Any live cell with more than three live neighbours dies",
                "as if by overcrowding.",
                "Any live cell with two or three live neighbours lives on to the next generation.",
                "Any dead cell with exactly three live neighbours becomes a live cell.",
                "Press any key to continue;",
                "\u001B",
                "\u001B",
                "How big would you like your grid:",
                "Please enter the width:",
                "Thank you!",
                "Please enter the height:",
                "Thank you!",
                "\u001B",
                "You will have to start the evolution by entering the start phase of the board.",
                "Separate each X|Y coordinate by a comma, and each pair but a backslash. eg: 3,3/4,1",
                "Please input your coordinates:",
                "Grid set.",
                "How many generations will it run for: ",
                "Thank you!",
                "\u001B",
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▣  ▣  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "\u001B",
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "\u001B",
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▣  ▣  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "Society stopped progressing, Thanks for playing!"
        ));

        game.runGame();

        Assert.assertEquals(expectedGameMessages.toString(), output.returnCollectedOutput().toString());
    }

    @Test
    public void gameRunsToCompletionWithValidationCorrection() {
        mockInput.add(0, "3.4");
        ArrayList<String> expectedGameMessages = new ArrayList<>(Arrays.asList(
                "Welcome to Conway's Game of Life!",
                "The rules are as followed:",
                "Any live cell with fewer than two live neighbours dies",
                "as if caused by underpopulation.",
                "Any live cell with more than three live neighbours dies",
                "as if by overcrowding.",
                "Any live cell with two or three live neighbours lives on to the next generation.",
                "Any dead cell with exactly three live neighbours becomes a live cell.",
                "Press any key to continue;",
                "\u001B",
                "\u001B",
                "How big would you like your grid:",
                "Please enter the width:",
                "Oops! Sorry that appears to be an invalid entry! Please try again:",
                "Thank you!",
                "Please enter the height:",
                "Thank you!",
                "\u001B",
                "You will have to start the evolution by entering the start phase of the board.",
                "Separate each X|Y coordinate by a comma, and each pair but a backslash. eg: 3,3/4,1",
                "Please input your coordinates:",
                "Grid set.",
                "How many generations will it run for: ",
                "Thank you!",
                "\u001B",
                "▢  ▢  ▢  ▢  ▢  \n" +
                        "▣  ▣  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "\u001B",
                "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▣  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "\u001B",
                "▢  ▢  ▢  ▢  ▢  \n" +
                        "▣  ▣  ▣  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n" +
                        "▢  ▢  ▢  ▢  ▢  \n",
                "Society stopped progressing, Thanks for playing!"
        ));

        game.runGame();

        Assert.assertEquals(expectedGameMessages.toString(), output.returnCollectedOutput().toString());
    }
}
