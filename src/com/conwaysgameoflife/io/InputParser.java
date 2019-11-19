package com.conwaysgameoflife.io;

import com.conwaysgameoflife.Coordinate;

import java.util.ArrayList;

public class InputParser {

    private String[] splitAtDeclaredDelimiter(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }

    public Coordinate parseSingleCoordinate(String singleUserInputCoordinate) {
        int x = 0;
        int y = 1;
        int[] parsedSingleCoordinateToInt = new int[2];
        String[] splitCoordinateString = splitAtDeclaredDelimiter(singleUserInputCoordinate, ",");

        parsedSingleCoordinateToInt[x] = Integer.parseInt(splitCoordinateString[x]) - 1;
        parsedSingleCoordinateToInt[y] = Integer.parseInt(splitCoordinateString[y]) - 1;

        return new Coordinate(parsedSingleCoordinateToInt[x], parsedSingleCoordinateToInt[y]);
    }

    public ArrayList<Coordinate> parseUserInputToCoordinates(String userInputSingleString) {
        String[] splitAtDelimiter = splitAtDeclaredDelimiter(userInputSingleString, "/");
        ArrayList<Coordinate> arrayOfParsedCoordinates = new ArrayList<>(splitAtDelimiter.length);

        for (String coordinate : splitAtDelimiter) {
            arrayOfParsedCoordinates.add(parseSingleCoordinate(coordinate));
        }

        return arrayOfParsedCoordinates;
    }

    public static String[] splitInputAtDelimiter(String userInput) {
        return userInput.split("/");
    }
}
