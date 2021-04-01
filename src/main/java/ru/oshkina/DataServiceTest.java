package ru.oshkina;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;

import static org.junit.Assert.*;

public class DataServiceTest {
    @Test
    public void firstTest(){
        DataService dataService = new DataService();
        double answer = dataService.wordsAverageLength();
        Assert.assertEquals(191, answer, 0);
    }

}