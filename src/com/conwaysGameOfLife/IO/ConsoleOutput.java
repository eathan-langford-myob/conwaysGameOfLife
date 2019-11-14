package com.conwaysGameOfLife.IO;

import java.util.concurrent.TimeUnit;

public class ConsoleOutput implements IOutput {
    @Override
    public void displayOutput(String string) {
        System.out.println(string);
    }

    @Override
    public void clearOutput() {
        System.out.println(System.lineSeparator().repeat(50));
        System.out.print("\033\143");
        System.out.print("\033[H\033[2J");
    }

    public void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
