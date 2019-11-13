package com.conwaysGameOfLife.IO;

import com.conwaysGameOfLife.Coordinate;

import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scanner;


    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    private String[] splitAtDeclaredDelimiter(String userInput, String delimiter) {
        return userInput.split(delimiter);
    }

    public Coordinate parseSingleCoordinate(String singleUserInputCoordinate) {
        int x = 0;
        int y = 1;
        int[] parsedSingleCoordinateToInt = new int[2];
        String[] splitCoordinateString = splitAtDeclaredDelimiter(singleUserInputCoordinate, ",");

        parsedSingleCoordinateToInt[x] = Integer.parseInt(splitCoordinateString[x]);
        parsedSingleCoordinateToInt[y] = Integer.parseInt(splitCoordinateString[y]);

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

}
