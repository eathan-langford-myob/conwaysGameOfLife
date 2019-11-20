package com.conwaysgameoflife.io;

import com.conwaysgameoflife.grid.Coordinate;

import java.util.ArrayList;

public class InputParser {

    public Coordinate parseSingleCoordinate(String singleUserInputCoordinate) {
        int x = 0;
        int y = 1;
        int[] parsedSingleCoordinateToInt = new int[2];
        String[] splitCoordinateString = singleUserInputCoordinate.split(",");

        parsedSingleCoordinateToInt[x] = Integer.parseInt(splitCoordinateString[x]) - 1;
        parsedSingleCoordinateToInt[y] = Integer.parseInt(splitCoordinateString[y]) - 1;

        return new Coordinate(parsedSingleCoordinateToInt[x], parsedSingleCoordinateToInt[y]);
    }

    public ArrayList<Coordinate> parseUserInputToCoordinates(String userInputStringOfCoordinates) {
        String[] splitAtDelimiter = userInputStringOfCoordinates.split("/");
        ArrayList<Coordinate> arrayOfParsedCoordinates = new ArrayList<>(splitAtDelimiter.length);

        for (String coordinate : splitAtDelimiter) {
            arrayOfParsedCoordinates.add(parseSingleCoordinate(coordinate));
        }

        return arrayOfParsedCoordinates;
    }
}
