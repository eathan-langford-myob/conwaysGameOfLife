package com.conwaysgameoflife.io;

import java.util.Scanner;

public class ConsoleInput implements IInput {
    private Scanner scanner;


    public ConsoleInput() {
        this.scanner = new Scanner(System.in);
    }

    @Override
    public String nextLine() {
        return scanner.nextLine();
    }

    @Override
    public void waitForInput() {
        try {
            System.in.read();
        }catch(Exception e){
            e.printStackTrace();
        }
    }


}
