package com.conwaysgameoflife.io;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ConsoleOutput implements IOutput {
    @Override
    public void displayOutput(String string) {
        System.out.println(string);
    }

    @Override
    public void clearOutput() {
        System.out.print("\f");
        System.out.print("\033[H\033[2J");
        System.out.print("\u001Bc");
        System.out.print(System.lineSeparator().repeat(70));
    }

    public void pause() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
