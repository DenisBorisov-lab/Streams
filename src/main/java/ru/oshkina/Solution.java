package ru.oshkina;

import java.util.Arrays;

public class Solution {

    private static final String PATH = "C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\main\\resources\\words.txt";

    public static void main(String[] args) {
        final StorageService storageService = new StorageService(PATH);
        DataService dataService = new DataService(storageService.getContent(), storageService.getWords(), Arrays.asList("ауеыоэяи".split("")));
        //1 - результат 191
        System.out.println(dataService.wordsAverageLength());
        //2 - сказал
        System.out.println(dataService.mostFrequentWord());
        //3 - покровительственный, распространявшийся, превосходительство...
        System.out.println(dataService.longestWords());
        //4 - Француженкою, пробившуюся, воображению...
        System.out.println(dataService.wordsWith5UniqueVowels());
    }
}
