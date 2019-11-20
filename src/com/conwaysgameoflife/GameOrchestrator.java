package com.conwaysgameoflife;

import com.conwaysgameoflife.grid.Coordinate;
import com.conwaysgameoflife.grid.Grid;
import com.conwaysgameoflife.io.GridInputValidator;
import com.conwaysgameoflife.io.IInput;
import com.conwaysgameoflife.io.IOutput;
import com.conwaysgameoflife.io.InputParser;
import com.conwaysgameoflife.render.GridRender;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

//RESOURCE BUNDLES DONT NEED TO RECOMPILE


public class GameOrchestrator {
    private IInput input;
    private IOutput output;
    private GridRender renderer;
    private InputParser parser;
    private ResourceBundle outputMessages;
    private Grid grid;

    public GameOrchestrator(IInput input, IOutput output, GridRender renderer, InputParser parser) {
        this.input = input;
        this.output = output;
        this.renderer = renderer;
        this.parser = parser;
        Locale locale = new Locale("en", "US");
        this.outputMessages = ResourceBundle.getBundle("com.conwaysgameoflife.io.OutputMessages", locale);
    }

    private void outputWelcomeMessage() {
        output.displayOutput(outputMessages.getString("welcome_message"));
        output.displayOutput(outputMessages.getString("tell_rules"));
        output.displayOutput(outputMessages.getString("rule_underpopulation"));
        output.displayOutput(outputMessages.getString("rule_overcrowding"));
        output.displayOutput(outputMessages.getString("rule_next_generation"));
        output.displayOutput(outputMessages.getString("rule_resurrect"));
        output.displayOutput(outputMessages.getString("generation_limit"));
        output.displayOutput(outputMessages.getString("press_enter"));
    }

    private int getValidBoardDimension() {
        boolean validBoardDimension = false;
        String positiveIntegerAsString = "";

        while (!validBoardDimension) {
            positiveIntegerAsString = input.nextLine();
            validBoardDimension = GridInputValidator.isPositiveInteger(positiveIntegerAsString);
            output.displayOutput(outputMessages.getString((validBoardDimension ? "confirm_positive_digit" : "invalid_entry")));
        }
        return Integer.parseInt(positiveIntegerAsString);
    }

    private Grid getInitialisedGrid() {
        output.displayOutput(outputMessages.getString("clearConsole"));
        output.displayOutput(outputMessages.getString("size_of_grid"));

        output.displayOutput(outputMessages.getString("ask_for_width"));
        int gridWidth = getValidBoardDimension();

        output.displayOutput(outputMessages.getString("ask_for_height"));
        int gridHeight = getValidBoardDimension();

        output.displayOutput(outputMessages.getString("clearConsole"));
        return new Grid(gridWidth, gridHeight);
    }


    private ArrayList<Coordinate> getCoordinatesOfLiveCellsFromInput() {
        boolean isValidInput = false;
        String userGivenCoordinates = "";

        while (!isValidInput) {
            output.displayOutput(outputMessages.getString("ask_for_input"));
            userGivenCoordinates = input.nextLine();
            isValidInput = GridInputValidator.isValidFormat(userGivenCoordinates, grid.getGridWidth(), grid.getGridHeight());
            output.displayOutput(outputMessages.getString((isValidInput ? "confirm_input" : "invalid_entry")));
        }
        return parser.parseUserInputToCoordinates(userGivenCoordinates);
    }

    private Grid getSeededGridFromInput() {
        output.displayOutput(outputMessages.getString("ask_to_seed_grid"));
        output.displayOutput(outputMessages.getString("tell_format"));

        ArrayList<Coordinate> gridConfiguration = getCoordinatesOfLiveCellsFromInput();
        grid.setLiveCells(gridConfiguration);
        return grid;
    }

    public void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void gameLoopTick(Grid grid) {
        //change name to action name, can contain tick, but name it better - done
        for (int cellGenerations = 0; cellGenerations <= 100; cellGenerations++) {
            grid = grid.getNextGenerationOfGrid();
            output.displayOutput(outputMessages.getString("clearConsole"));
            output.displayOutput(renderer.renderGrid(grid));
            this.pause();
        }
    }


    public void runGame() {
        this.outputWelcomeMessage();
        input.prompt();
        output.displayOutput(outputMessages.getString("clearConsole"));
        grid = this.getInitialisedGrid();
        grid = this.getSeededGridFromInput();
        output.displayOutput(renderer.renderGrid(grid));
        this.gameLoopTick(grid);
        output.displayOutput(outputMessages.getString("end_game"));
        output.displayOutput(outputMessages.getString("clearConsole"));
    }


}
