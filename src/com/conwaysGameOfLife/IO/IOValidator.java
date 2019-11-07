package com.conwaysGameOfLife.IO;

import com.conwaysGameOfLife.Grid;

public class IOValidator {

    public static boolean isValidFormatWithDigits(String input){
        if(input.contains(",") && input.length() == 3 && !input.contains("0")){
            return input.replace(",","").chars().allMatch(Character::isDigit);
        }
        return false;
    }

    public static boolean isValidInputWithinBoardRange(String input, Grid grid) {
        String[] stringArrayOfInput = input.split(",");
        int[] arrayFromSplitInput = new int[2];
        arrayFromSplitInput[0] = Integer.parseInt(stringArrayOfInput[0]);
        arrayFromSplitInput[1] = Integer.parseInt(stringArrayOfInput[1]);
        return (arrayFromSplitInput[0] <= grid.getGridWidth()) && (arrayFromSplitInput[1] <= grid.getGridHeight()) && (stringArrayOfInput[0].length() == stringArrayOfInput[1].length());
    }
}
