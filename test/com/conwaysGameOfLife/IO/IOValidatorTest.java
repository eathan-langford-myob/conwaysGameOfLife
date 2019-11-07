package com.conwaysGameOfLife.IO;

import com.conwaysGameOfLife.*;
import org.junit.*;

public class IOValidatorTest {
    private String userInputValidString;

    @Before
    public void setUp(){
        userInputValidString = "3,1";
    }

    @After
    public void tearDown(){
        userInputValidString = null;
    }

    @Test
    public void shouldReturnTrue_WhenValidFormatString(){
        boolean actual = IOValidator.isValidFormatWithDigits(userInputValidString);

        Assert.assertTrue(actual);
    }

    @Test
    public void shouldReturnTrue_WhenIntegersWithinBoundsOfGrid() {
        Grid grid = new Grid(3,3);
        boolean actual = IOValidator.isValidInputWithinBoardRange(userInputValidString, grid);

        Assert.assertTrue(actual);
    }
}
