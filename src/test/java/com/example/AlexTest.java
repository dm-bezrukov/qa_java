package com.example;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AlexTest {
    @Mock
    Feline feline;
    Alex alex;

    @Test
    public void getKittensReturnsZero() {
        try {
            alex = new Alex(feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Mockito.when(feline.getKittens(0)).thenReturn(0);
        Assert.assertEquals("Ожидалось: 0", 0, alex.getKittens());
    }

    @Test
    public void doesHaveManeReturnsTrue() {
        try {
            alex = new Alex(feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertTrue("Ожидалось: true", alex.doesHaveMane());
    }

    @Test
    public void getFoodReturnsListOfPredatorFood() {
        try {
            alex = new Alex(feline);
            Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
            Assert.assertEquals("Ожидался рацион хищника", List.of("Животные", "Птицы", "Рыба"), alex.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getFriendsReturnsAlexFriends() {
        try {
            alex = new Alex(feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals("Ожидался список из 3 друзей Алекса", List.of( "Марти", "Глория", "Мелман"), alex.getFriends());
    }

    @Test
    public void getPlaceOfLivingReturnsNyZoo() {
        try {
            alex = new Alex(feline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        Assert.assertEquals( "Ожидалось: Нью-Йоркский зоопарк", "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
}