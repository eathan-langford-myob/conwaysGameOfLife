package com.conwaysGameOfLife.IO;

public class ConsoleInputMock implements IInput {
public String mockInput;

public ConsoleInputMock(String input) {
        this.mockInput = input;
        }


@Override
public String nextLine() {
        return mockInput;
        }

        @Override
        public void prompt() {

        }
}