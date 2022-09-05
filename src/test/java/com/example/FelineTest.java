package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class FelineTest {

    Feline feline;

    @Before
    public void init() {
        this.feline = new Feline();
    }
    @Test
    public void eatMeatReturnsListOfPredatorFood() {
        try {
            Assert.assertEquals("Ожидался рацион хищника",
                    List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getKittensWithNoArgumentReturns1() {
        Assert.assertEquals("Ожидалось 1", 1, feline.getKittens());
    }

    @Test
    public void getKittens1Returns1() {
        Assert.assertEquals("Ожидалось 1", 1, feline.getKittens(1));
    }

    @Test
    public void getFamilyReturnsFeline() {
        Assert.assertEquals("Ожидалось \"Кошачьи\"", "Кошачьи",feline.getFamily());
    }

}