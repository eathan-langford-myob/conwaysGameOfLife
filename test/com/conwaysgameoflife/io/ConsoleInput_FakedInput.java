package com.conwaysgameoflife.io;

public class ConsoleInput_FakedInput implements IInput {
    private int counter = -1;
    public String[] mockInput;

    public ConsoleInput_FakedInput(String[] input) {
        this.mockInput = input;
    }


    @Override
    public String nextLine() {
        counter++;
        return mockInput[counter];
    }

    @Override
    public void prompt() {

    }
}