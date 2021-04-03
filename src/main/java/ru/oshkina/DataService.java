package ru.oshkina;


import java.util.*;
import java.util.stream.Collectors;

public class DataService {

    final List<String> content;
    final List<String> words;
    final List<String> strings;

    public DataService(List<String> content, List<String> words, List<String> strings) {
        this.content = content;
        this.strings = strings;
        this.words = words;
    }

    //Определить среднюю длину строки в файле words.txt (результат округляем, пустые строки не считаем)
    public double wordsAverageLength() {
        List<String> collect = content.stream()
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
        double length = collect.size();
        Optional<Integer> reduce = collect.stream()
                .map(String::length)
                .reduce(Integer::sum);
        int i = reduce.get();
        return Math.round(i / length);
    }

    //Найти 30 самых длинных слов
    public List<String> longestWords() {
        return words.stream()
                .sorted((o1, o2) -> o2.length() - o1.length())
                .limit(31)
                .distinct()
                .collect(Collectors.toList());

    }

    //Найти слово, которое встречается чаще всего и содержит больше 3 символов (ignore case = true) hello HEllOO
    public String mostFrequentWord() {
        return words.stream()
                .filter(s -> s.length() > 3)
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream().
                        max(Map.Entry.comparingByValue())
                .orElseThrow(UnsupportedOperationException::new)
                .getKey();
    }

    //Найти все слова в которых содержатся более 4 уникальных гласных в файле words.txt (выполнять параллельно)
    public List<String> wordsWith5UniqueVowels() {
        return words.parallelStream()
                .filter(s -> cnt(s).size() > 4)
                .distinct()
                .collect(Collectors.toList());
    }

    public Set<String> cnt(String s) {
        return Arrays.stream(s.split(""))
                .filter(strings::contains)
                .collect(Collectors.toSet());
    }

}