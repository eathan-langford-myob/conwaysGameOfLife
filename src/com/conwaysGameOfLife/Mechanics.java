package com.conwaysGameOfLife;

import com.conwaysGameOfLife.IO.IInput;
import com.conwaysGameOfLife.IO.IOValidator;
import com.conwaysGameOfLife.IO.IOutput;
import com.conwaysGameOfLife.IO.InputParser;
import com.conwaysGameOfLife.Render.GridRender;

import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;


public class Mechanics {
    private IInput input;
    private IOutput output;
    private GridRender renderer;
    private InputParser parse;
    private String userCoordinates;
    private ResourceBundle messages;
    private Grid grid;
    private ArrayList<Coordinate> nextGridState;

    public Mechanics(IInput input, IOutput output, GridRender renderer, InputParser parse) {
        this.input = input;
        this.output = output;
        this.renderer = renderer;
        this.parse = parse;
        Locale locale = new Locale("en", "US");
        this.messages = ResourceBundle.getBundle("com.conwaysGameOfLife.IO.OutputMessages", locale);
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

    private Grid askForGridSize() {
        output.clearOutput();
        output.displayOutput(messages.getString("size_of_grid"));
        output.displayOutput(messages.getString("width"));
        int gridWidth = Integer.parseInt(input.nextLine());
        output.displayOutput(messages.getString("height"));
        int gridHeight = Integer.parseInt(input.nextLine());
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
        grid.clear();
        ArrayList<Coordinate> gridConfiguration = getGridConfiguration();
        grid.setLiveCells(gridConfiguration);
        return grid;
    }

    private void loopGridTick() {
        for (int generations = 0; generations <= 100; generations++) {
            output.displayOutput(renderer.renderGrid(grid));
            nextGridState = grid.getCoordinatesOfNextGenerationsCells();
            grid.setLiveCells(nextGridState);
            output.pause();
            output.clearOutput();
        }
    }

    public void runGame() {
        grid = setUp();
        grid = setGridConfiguration();
        loopGridTick();
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
