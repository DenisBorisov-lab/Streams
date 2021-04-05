package ru.oshkina;

import YAML.ReadingYAML;
import YAML.Types;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataServiceTest {

    ReadingYAML reader = new ReadingYAML();
    private final String GENERAL = reader.read(Types.GENERAL);
    private final String TEST = reader.read(Types.TEST);
    private final StorageService generalService = new StorageService(GENERAL);
    private final StorageService testService = new StorageService(TEST);
    private final List<String> content = generalService.getContent();
    private final List<String> words = generalService.getWords();
    private final List<String> wordsForTest = testService.getWords();
    private final List<String> strings = Arrays.asList("ауеыоэяию".split(""));
    private final DataService generalDataService = new DataService(content, words, strings);
    private final DataService testDataService = new DataService(content, wordsForTest, strings);

    @Test
    public void firstTest() {
        double answer = generalDataService.wordsAverageLength();
        Assert.assertEquals(191, answer, 0);
    }

    @Test
    public void secondTest(){
        String answer = generalDataService.mostFrequentWord();
        Assert.assertEquals("сказал", answer);
    }

    @Test
    public void thirdTest(){
        wordsForTest.sort((o1, o2) -> o2.length() - o1.length());
        List<String> expectedList = testDataService.longestWords();
        boolean answer = true;
        for (int i = 0; i < 30; i++){
            if (!expectedList.get(i).equals(wordsForTest.get(i))){
                answer = false;
                break;
            }
        }
        Assert.assertTrue(answer);
    }

    @Test
    public void fourthTest(){
        boolean answer = false;
        List<String> strings = testDataService.wordsWith5UniqueVowels();
        if (strings.size() == 1 && strings.get(0).equals("воображению")){
            answer = true;
        }
        Assert.assertTrue(answer);
    }
}