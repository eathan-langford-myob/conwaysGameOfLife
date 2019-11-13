package com.conwaysGameOfLife.IO;

public class IOValidator {


    public static boolean isValidCoordinateFormat(String input) {
        if (input.contains(",") && input.length() == 3 && !input.contains("0")) {
            return input.replace(",", "").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidDelimiter(String userInput) {
        return userInput.contains("/");
    }

    public static String[] splitInputAtDelimiter(String userInput) {
        return userInput.split("/");
    }

    public static boolean validateEachCoordinateInUserInput(String userInput,  int gridWidth, int gridHeight) {
        String[] arrayFromInput = splitInputAtDelimiter(userInput);
        for (String singleCoordinate : arrayFromInput) {
            if (!isValidCoordinateFormat(singleCoordinate) || !isValidInputWithinBoardRange(singleCoordinate, gridWidth, gridHeight)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidInputWithinBoardRange(String singleCoordinate, int gridWidth, int gridHeight) {
        String[] stringArrayOfInput = singleCoordinate.split(",");
        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        return (arrayFromSplitInput[0] <= gridWidth) && (arrayFromSplitInput[1] <= gridHeight) && (stringArrayOfInput[0].length() == stringArrayOfInput[1].length());
    }

    public static boolean validateUserInput(String userInput, int gridWidth, int gridHeight) {
        return isValidDelimiter(userInput) &&
                validateEachCoordinateInUserInput(userInput, gridWidth, gridHeight);
    }
}
