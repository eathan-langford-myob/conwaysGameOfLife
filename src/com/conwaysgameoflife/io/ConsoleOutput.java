package com.conwaysgameoflife.io;

public class ConsoleOutput implements IOutput {
    @Override
    public void displayOutput(String string) {
        System.out.println(string);
    }
}
