package ru.oshkina;

import org.junit.Assert;
import org.junit.Test;

import javax.xml.crypto.Data;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DataServiceTest {

    @Test
    public void firstTest() {

        List<String> content = new ArrayList<>();

        List<String> words = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        DataService dataService = new DataService(content, words, strings);
        double answer = dataService.wordsAverageLength();
        Assert.assertEquals(191, answer, 0);
    }

}