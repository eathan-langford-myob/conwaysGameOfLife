package com.conwaysgameoflife.io;
// raname class to something better, gridInputValidator - done

public class GridInputValidator {
    private static int x = 0;
    private static int y = 1;

    public static boolean isValidSingleCoordinateFormat(String input) {
        if (input.contains(",")) {
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    //has or is in method names returning bools - done
    public static boolean hasValidDelimiterOrSingleCoordinateFormat(String userInput) {
        return userInput.contains("/") || isValidSingleCoordinateFormat(userInput);
    }

    public static boolean isPositiveInteger(String userInput) {
        if (!userInput.isEmpty()) {
            return userInput.chars().allMatch(Character::isDigit) && Integer.parseInt(userInput) > 0;
        }
        return false;
    }

    public static boolean isEachCoordinateValidInUserInput(String userInput, int gridWidth, int gridHeight) {
        String[] arrayFromInput = userInput.split("/");
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

    public static boolean isValidFormat(String userInput, int gridWidth, int gridHeight) {
        return hasValidDelimiterOrSingleCoordinateFormat(userInput) &&
                isEachCoordinateValidInUserInput(userInput, gridWidth, gridHeight);
    }
}
