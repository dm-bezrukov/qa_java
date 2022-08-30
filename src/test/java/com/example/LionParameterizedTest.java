package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

@RunWith(Parameterized.class)
public class LionParameterizedTest {

    private final String lionSex;
    private final Boolean expectedResult;
    @Mock
    Feline feline;
    Lion lion;

    public LionParameterizedTest(String lionSex, Boolean expectedResult) {
        this.lionSex = lionSex;
        this.expectedResult = expectedResult;
    }

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
    }

    @Parameterized.Parameters
    public static Object[][] getTextData() {
        return new Object[][]{
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Test
    public void doesHaveManeReturnsProperBoolean() {
        try {
            lion = new Lion(lionSex, feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Ожидалось " + expectedResult, expectedResult, lion.doesHaveMane());
    }
}