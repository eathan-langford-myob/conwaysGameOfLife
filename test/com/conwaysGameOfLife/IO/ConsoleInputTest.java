package com.conwaysGameOfLife.IO;

import org.junit.Assert;
import org.junit.Test;

public class ConsoleInputTest {

    @Test
    public void shouldReturnStringGiven_WhenUserInputIsCalled() {
        IInput userInput = new ConsoleInputMock("Hello World");

        String actual = userInput.getInput();
        String expected = "Hello World";

        Assert.assertEquals(expected, actual);
    }


}
