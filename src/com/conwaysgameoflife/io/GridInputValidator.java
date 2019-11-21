package com.conwaysgameoflife.io;

public class GridInputValidator {
    private static int x = 0;
    private static int y = 1;

    public static boolean isValidSingleCoordinateFormat(String input) {
        if (input.contains(",")) {
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean hasValidDelimiterOrSingleCoordinateFormat(String input) {
        return input.contains("/") || isValidSingleCoordinateFormat(input);
    }

    public static boolean isPositiveInteger(String input) {
        if (!input.isEmpty()) {
            return input.chars().allMatch(Character::isDigit) && Integer.parseInt(input) > 0;
        }
        return false;
    }

    public static boolean isEachCoordinateValidInInput(String input, int gridWidth, int gridHeight) {
        String[] arrayFromInput = input.split("/");
        for (String singleCoordinate : arrayFromInput) {
            if (!isValidSingleCoordinateFormat(singleCoordinate) || !isValidInputWithinBoardRange(singleCoordinate, gridWidth, gridHeight)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isInputWithinBoardRange(int[] arrayOf_XY_Coordinate, int gridWidth, int gridHeight) {
        boolean withinBoardWidthRange = (arrayOf_XY_Coordinate[x] <= gridWidth) && (arrayOf_XY_Coordinate[x] > 0);
        boolean withinBoardHeightRange = (arrayOf_XY_Coordinate[y] <= gridHeight) && (arrayOf_XY_Coordinate[y] > 0);
        return withinBoardWidthRange && withinBoardHeightRange;
    }

    public static boolean isValidInputWithinBoardRange(String singleCoordinate, int gridWidth, int gridHeight) {
        String[] stringArrayOfInput = singleCoordinate.split(",");

        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[x] = Integer.parseInt(stringArrayOfInput[x]);
        arrayFromSplitInput[y] = Integer.parseInt(stringArrayOfInput[y]);
        return isInputWithinBoardRange(arrayFromSplitInput, gridWidth, gridHeight);
    }

    public static boolean isValidFormat(String input, int gridWidth, int gridHeight) {
        return hasValidDelimiterOrSingleCoordinateFormat(input) &&
                isEachCoordinateValidInInput(input, gridWidth, gridHeight);
    }
}
