package ru.oshkina;

import YAML.ReadingYAML;
import YAML.Types;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        final StorageService storageService = new StorageService(new ReadingYAML().read(Types.GENERAL));
        DataService dataService = new DataService(storageService.getContent(), storageService.getWords(), Arrays.asList("ауеыоэяию".split("")));
        //1 - результат 191
        System.out.println(dataService.wordsAverageLength());
        //2 - сказал
        System.out.println(dataService.mostFrequentWord());
        //3 - покровительственный, распространявшийся, превосходительство...z
        System.out.println(dataService.longestWords());
        //4 - Француженкою, пробившуюся, воображению...
        System.out.println(dataService.wordsWith5UniqueVowels());
    }
}
