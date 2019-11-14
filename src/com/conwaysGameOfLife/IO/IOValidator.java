package com.conwaysGameOfLife.IO;

public class IOValidator {


    public static boolean isValidCoordinateFormat(String input) {
        if (input.contains(",")) {
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean containsValidDelimiter(String userInput) {
        return userInput.contains("/") || isValidCoordinateFormat(userInput);
    }

    public static String[] splitInputAtDelimiter(String userInput) {
        return userInput.split("/");
    }

    public static boolean isEachCoordinateValidInUserInput(String userInput, int gridWidth, int gridHeight) {
        String[] arrayFromInput = splitInputAtDelimiter(userInput);
        for (String singleCoordinate : arrayFromInput) {
            if (!isValidCoordinateFormat(singleCoordinate) || !isValidInputWithinBoardRange(singleCoordinate, gridWidth, gridHeight)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkWithinBoardRange(int[] arrayOf_XY_Coordinate, int gridWidth, int gridHeight) {
        return (arrayOf_XY_Coordinate[0] <= gridWidth) && (arrayOf_XY_Coordinate[0] > 0)
                && (arrayOf_XY_Coordinate[1] <= gridHeight) && (arrayOf_XY_Coordinate[1] > 0);
    }

    public static boolean isValidInputWithinBoardRange(String singleCoordinate, int gridWidth, int gridHeight) {
        String[] stringArrayOfInput = singleCoordinate.split(",");

        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        return checkWithinBoardRange(arrayFromSplitInput, gridWidth, gridHeight);
    }

    public static boolean validateUserInput(String userInput, int gridWidth, int gridHeight) {
        return containsValidDelimiter(userInput) &&
                isEachCoordinateValidInUserInput(userInput, gridWidth, gridHeight);
    }
}
