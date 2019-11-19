package com.conwaysgameoflife;

import com.conwaysgameoflife.io.IInput;
import com.conwaysgameoflife.io.IOValidator;
import com.conwaysgameoflife.io.IOutput;
import com.conwaysgameoflife.io.InputParser;
import com.conwaysgameoflife.render.GridRender;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class GameOrchestrator {
    private IInput input;
    private IOutput output;
    private GridRender renderer;
    private InputParser parse;
    private ResourceBundle messages;
    private Grid grid;
    private ArrayList<Coordinate> nextGridState;

    public GameOrchestrator(IInput input, IOutput output, GridRender renderer, InputParser parse) {
        this.input = input;
        this.output = output;
        this.renderer = renderer;
        this.parse = parse;
        Locale locale = new Locale("en", "US");
        this.messages = ResourceBundle.getBundle("com.conwaysgameoflife.io.OutputMessages", locale);
    }

    private void welcome() {
        output.displayOutput(messages.getString("welcome_message"));
        output.displayOutput(messages.getString("tell_rules"));
        output.displayOutput(messages.getString("underpopulation"));
        output.displayOutput(messages.getString("overcrowding"));
        output.displayOutput(messages.getString("next_generation"));
        output.displayOutput(messages.getString("resurrect"));
        output.displayOutput(messages.getString("generation_limit"));
        output.displayOutput(messages.getString("press_enter"));
    }

    private void askForGridConfiguration() {
        output.displayOutput(messages.getString("ask_to_seed_grid"));
        output.displayOutput(messages.getString("tell_format"));
    }

    private int validationLoopForBoardDimensionSetting() {
        boolean validBoardDimension = false;
        String singleDigitAsString = "";

        while (!validBoardDimension) {
            singleDigitAsString = input.nextLine();
            validBoardDimension = IOValidator.validateSingleIntegerForBoardDimensions(singleDigitAsString);
            output.displayOutput(messages.getString((validBoardDimension ? "confirm_single_digit" : "invalid_entry")));
        }
        return Integer.parseInt(singleDigitAsString);
    }

    private Grid askForGridSize() {
        output.clearOutput();
        output.displayOutput(messages.getString("size_of_grid"));

        output.displayOutput(messages.getString("width"));
        int gridWidth = validationLoopForBoardDimensionSetting();

        output.displayOutput(messages.getString("height"));
        int gridHeight = validationLoopForBoardDimensionSetting();

        output.clearOutput();
        return new Grid(gridWidth, gridHeight);
    }


    private ArrayList<Coordinate> getGridConfiguration() {
        boolean validInput = false;
        String userGivenCoordinates = "";
        while (!validInput) {
            output.displayOutput(messages.getString("ask_for_input"));
            userGivenCoordinates = input.nextLine();
            validInput = IOValidator.validateUserInput(userGivenCoordinates, grid.getGridWidth(), grid.getGridHeight());
            output.displayOutput(messages.getString((validInput ? "confirm_input" : "invalid_entry")));
        }
        return parse.parseUserInputToCoordinates(userGivenCoordinates);
    }

    private Grid setUp() {
        welcome();
        input.prompt();
        output.clearOutput();
        grid = askForGridSize();
        return grid;
    }

    private Grid setGridConfiguration() {
        askForGridConfiguration();
        ArrayList<Coordinate> gridConfiguration = getGridConfiguration();
        grid.setLiveCells(gridConfiguration);
        return grid;
    }

    private Grid setNextStateOfGeneration(Grid grid) {
        nextGridState = grid.getCoordinatesOfNextGenerationsCells();
        Grid nextGenerationGrid = new Grid(grid.getGridWidth(), grid.getGridHeight());
        nextGenerationGrid.setLiveCells(nextGridState);
        return nextGenerationGrid;
    }


    private void loopingTick(Grid grid) {
        for (int cellGenerations = 0; cellGenerations <= 100; cellGenerations++) {
            grid = setNextStateOfGeneration(grid);
            output.pause();
            output.clearOutput();
            output.displayOutput("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            output.displayOutput(renderer.renderGrid(grid));
        }
    }


    public void runGame() {
        grid = setUp();
        grid = setGridConfiguration();
        output.displayOutput(renderer.renderGrid(grid));
        loopingTick(grid);
        output.clearOutput();
    }

    //    private String getUserConfigurationWithValidation(boolean validInput, String userGivenCoordinates) {
//        while (!validInput) {
//            output.displayOutput(messages.getString("ask_for_input"));
//            userGivenCoordinates = input.nextLine();
//            validInput = IOValidator.validateUserInput(userGivenCoordinates, grid.getGridWidth(), grid.getGridHeight());
//            output.displayOutput(messages.getString((validInput ? "confirm_input" : "invalid_entry")));
//        }
//        return userGivenCoordinates;
//    }

}
