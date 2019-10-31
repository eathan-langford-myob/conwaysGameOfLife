package com.conwaysGameOfLife.IO;

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
    public void shouldReturnTrueForValidFormatString(){
        boolean actual = IOValidator.isValidFormatWithDigits(userInputValidString);

        Assert.assertTrue(actual);
    }
}
