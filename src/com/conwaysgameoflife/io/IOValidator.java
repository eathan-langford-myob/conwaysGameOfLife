package com.conwaysgameoflife.io;

public class IOValidator {
    private static int x = 0;
    private static int y = 1;

    public static boolean isValidCoordinateFormat(String input) {
        if (input.contains(",")) {
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean containsValidDelimiter(String userInput) {
        return userInput.contains("/") || isValidCoordinateFormat(userInput);
    }

    public static boolean validateSingleIntegerForBoardDimensions(String userInput) {
        return userInput.chars().allMatch(Character::isDigit) && !userInput.equals("") && !userInput.equals("0");
    }

    public static boolean isEachCoordinateValidInUserInput(String userInput, int gridWidth, int gridHeight) {
        String[] arrayFromInput = InputParser.splitInputAtDelimiter(userInput);
        for (String singleCoordinate : arrayFromInput) {
            if (!isValidCoordinateFormat(singleCoordinate) || !isValidInputWithinBoardRange(singleCoordinate, gridWidth, gridHeight)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkWithinBoardRange(int[] arrayOf_XY_Coordinate, int gridWidth, int gridHeight) {
        boolean withinBoardWidthRange = (arrayOf_XY_Coordinate[x] <= gridWidth) && (arrayOf_XY_Coordinate[x] > 0);
        boolean withinBoardHeightRange = (arrayOf_XY_Coordinate[y] <= gridHeight) && (arrayOf_XY_Coordinate[y] > 0);
        return withinBoardWidthRange && withinBoardHeightRange;
    }

    public static boolean isValidInputWithinBoardRange(String singleCoordinate, int gridWidth, int gridHeight) {
        String[] stringArrayOfInput = singleCoordinate.split(",");

        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[x] = Integer.parseInt(stringArrayOfInput[x]);
        arrayFromSplitInput[y] = Integer.parseInt(stringArrayOfInput[y]);
        return checkWithinBoardRange(arrayFromSplitInput, gridWidth, gridHeight);
    }

    public static boolean validateUserInput(String userInput, int gridWidth, int gridHeight) {
        return containsValidDelimiter(userInput) &&
                isEachCoordinateValidInUserInput(userInput, gridWidth, gridHeight);
    }
}
