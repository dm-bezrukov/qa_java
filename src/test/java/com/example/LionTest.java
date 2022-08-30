package com.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;
    Lion lion;

    @Test
    public void getKittensReturnsFelineKittensCount() {
        try {
            lion = new Lion("Самец", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.when(feline.getKittens()).thenReturn(5);
        Assert.assertEquals("Ожидалось 5", 5, lion.getKittens());
    }

    @Test
    public void getFoodReturnsListOfPredatorFood() {
        try {
            lion = new Lion("Самка", feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals("Ожидался рацион хищника", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test(expected = Exception.class)
    public void constructorWrongLionSexReturnsException() {
        try {
            lion = new Lion("Undefined", feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}