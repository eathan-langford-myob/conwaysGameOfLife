package com.conwaysGameOfLife.IO;

import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scanner;

    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String getInput() {
        return scanner.nextLine();
    }
}
