package ru.oshkina;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DataServiceTest {

    private final String PATH = "C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\main\\resources\\words.txt";
    private final StorageService storageService = new StorageService(PATH);
    private List<String> content = storageService.getContent();
    private List<String> words = storageService.getWords();
    private List<String> strings = Arrays.asList("ауеыоэяи".split(""));
    private DataService dataService = new DataService(content, words, strings);

    @Test
    public void firstTest() {
        double answer = dataService.wordsAverageLength();
        Assert.assertEquals(191, answer, 0);
    }

    @Test
    public void secondTest(){
        String answer = dataService.mostFrequentWord();
        Assert.assertEquals("сказал", answer);
    }

    @Test
    public void thirdTest(){
        String value = "перекладных небольшого остальными записками состояла чемодана половины путевыми потеряна Тифлиса поклажа тележки который Большая счастию чемодан счастью остался одного Грузии вещами набит часть ехал моей меня Вся был них для вас";
        List<String> strings = Arrays.asList(value.split(" "));
    }

}