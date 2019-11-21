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
        output.displayOutput(outputMessages.getString("press_enter"));
    }

    private int getAndValidateGridSetting() {
        boolean validBoardDimension = false;
        String positiveIntegerAsString = "";

        while (!validBoardDimension) {
            positiveIntegerAsString = input.nextLine();
            validBoardDimension = GridInputValidator.isPositiveInteger(positiveIntegerAsString);
            output.displayOutput(outputMessages.getString((validBoardDimension ? "confirm_positive_digit" : "invalid_entry")));
        }
        return Integer.parseInt(positiveIntegerAsString);
    }


    private ArrayList<Coordinate> getCoordinatesOfLiveCellsFromInput(int gridWidth, int gridHeight) {
        boolean isValidInput = false;
        String givenCoordinates = "";

        while (!isValidInput) {
            output.displayOutput(outputMessages.getString("ask_for_input"));
            givenCoordinates = input.nextLine();
            isValidInput = GridInputValidator.isValidFormat(givenCoordinates, gridWidth, gridHeight);
            output.displayOutput(outputMessages.getString((isValidInput ? "confirm_input" : "invalid_entry")));
        }
        return parser.parseInputToCoordinates(givenCoordinates);
    }

    private Grid getSeededGridFromInput() {
        output.displayOutput(outputMessages.getString("clear_console"));
        output.displayOutput(outputMessages.getString("size_of_grid"));

        output.displayOutput(outputMessages.getString("ask_for_width"));
        int gridWidth = getAndValidateGridSetting();

        output.displayOutput(outputMessages.getString("ask_for_height"));
        int gridHeight = getAndValidateGridSetting();

        output.displayOutput(outputMessages.getString("clear_console"));

        output.displayOutput(outputMessages.getString("ask_to_seed_grid"));
        output.displayOutput(outputMessages.getString("tell_format"));

        ArrayList<Coordinate> gridConfiguration = getCoordinatesOfLiveCellsFromInput(gridWidth, gridHeight);

        return new Grid(gridWidth, gridHeight, gridConfiguration);
    }

    private void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void gameLoopTick(Grid grid, int generations) {
        tick:for (int cellGenerations = 0; cellGenerations <= generations; cellGenerations++) {
            if (grid.getNextGenerationOfGrid().equals(grid)) {
                break tick;
            }
            grid = grid.getNextGenerationOfGrid();
            output.displayOutput(outputMessages.getString("clear_console"));
            String gridString = renderer.renderGrid(grid);
            output.displayOutput(gridString);
            pause();
        }
    }

    private int getGenerationAmount() {
        output.displayOutput(outputMessages.getString("generations_amount"));
        return getAndValidateGridSetting();
    }

    public void runGame() {
        outputWelcomeMessage();
        input.waitForInput();
        output.displayOutput(outputMessages.getString("clear_console"));
        grid = getSeededGridFromInput();
        int generationsAmount = getGenerationAmount();
        gameLoopTick(grid, generationsAmount);
        output.displayOutput(outputMessages.getString("end_game"));
    }
}
