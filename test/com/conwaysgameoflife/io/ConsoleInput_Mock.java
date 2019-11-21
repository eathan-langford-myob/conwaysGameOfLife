package com.conwaysgameoflife.io;

import java.util.ArrayList;

public class ConsoleInput_Mock implements IInput {
    private int counter = 0;
    private ArrayList<String> mockedInputData;


    public ConsoleInput_Mock(ArrayList<String> givenData) {
        mockedInputData = givenData;
    }

    @Override
    public String nextLine() {
        String input = mockedInputData.get(counter);
        counter++;
        return input;
    }

    @Override
    public void waitForInput() {
    }


}
