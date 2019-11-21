package com.conwaysgameoflife.io;

import com.conwaysgameoflife.grid.Coordinate;

import java.util.ArrayList;

public class InputParser {

    Coordinate parseSingleCoordinate(String singleInputCoordinate) {
        int x = 0;
        int y = 1;
        int[] parsedSingleCoordinateToInt = new int[2];
        String[] splitCoordinateString = singleInputCoordinate.split(",");

        parsedSingleCoordinateToInt[x] = Integer.parseInt(splitCoordinateString[x]) - 1;
        parsedSingleCoordinateToInt[y] = Integer.parseInt(splitCoordinateString[y]) - 1;

        return new Coordinate(parsedSingleCoordinateToInt[x], parsedSingleCoordinateToInt[y]);
    }

    public ArrayList<Coordinate> parseInputToCoordinates(String inputStringOfCoordinates) {
        String[] splitAtDelimiter = inputStringOfCoordinates.split("/");
        ArrayList<Coordinate> arrayOfParsedCoordinates = new ArrayList<>(splitAtDelimiter.length);

        for (String coordinate : splitAtDelimiter) {
            arrayOfParsedCoordinates.add(parseSingleCoordinate(coordinate));
        }

        return arrayOfParsedCoordinates;
    }
}
