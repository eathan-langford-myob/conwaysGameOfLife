package com.conwaysgameoflife.io;

import java.util.ArrayList;

public class ConsoleOutput_Mock implements IOutput {
    ArrayList<String> collectedOutput = new ArrayList<>();

    public ArrayList<String> returnCollectedOutput() {
        return collectedOutput;
    }

    @Override
    public void displayOutput(String string) {
        collectedOutput.add(string);
    }
}
