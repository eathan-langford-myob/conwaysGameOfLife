package com.conwaysgameoflife.io;

import org.junit.*;

public class ConsoleInputTest {
    ConsoleInput input;

    @Before
    public void setUp() {
        input = new ConsoleInput();
    }

    @After
    public void tearDown() {
        input = null;
    }

    @Test
    public void shouldReturnStringGiven_WhenUserInputIsCalled() {
        IInput userInput = new ConsoleInputMock("Hello World");

        String actual = userInput.nextLine();
        String expected = "Hello World";

        Assert.assertEquals(expected, actual);
    }
}
