package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline feline;
    Cat cat;

    @Before
    public void init() {
        cat = new Cat(feline);
    }

    @Test
    public void soundReturnsMeow() {
        Assert.assertEquals("Ожидался звук \"Мяу\"", "Мяу", cat.getSound());
    }

    @Test
    public void getFoodReturnsListOfPredatorFood() {
        try {
            Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals("Ожидался рацион хищника", List.of("Животные", "Птицы", "Рыба"), cat.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}