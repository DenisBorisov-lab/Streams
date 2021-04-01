package ru.oshkina;



import java.util.*;
import java.util.stream.Collectors;

public class DataService {

    private final StorageService storageService = new StorageService();
    final List<String> content = new StorageService().getContent();
    final List<String> words = new StorageService().getWords();

    //Определить среднюю длину строки в файле words.txt (результат округляем, пустые строки не считаем)
    public double wordsAverageLength() {
        List<String> collect = content.stream()
                .filter(s -> s.length() > 0)
                .collect(Collectors.toList());
        double length = collect.size();
        Optional<Integer> reduce = collect.stream()
                .map(s -> s.length())
                .reduce((x, y) -> x + y);
        int i = reduce.get();
        return Math.round(i / length);
    }

    //Найти 30 самых длинных слов
    public List<String> longestWords() {
        Set<String> collect = words.stream()
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o2.length() - o1.length();
                    }
                })
                .limit(31)
                .collect(Collectors.toSet());
        List<String> result = new ArrayList<>(collect);
        return result;
    }

    //Найти слово, которое встречается чаще всего и содержит больше 3 символов (ignore case = true)
    public String mostFrequentWord() {
        List<String> filteredWords = words.stream()
                .filter(s -> s.length() > 3)
                .collect(Collectors.toList());
        Set<String> collect = filteredWords.stream()
                .collect(Collectors.toSet());
        List<String> set = new ArrayList<>(collect);
        String maxString = "";
        int max = 0;
        for (int i = 0; i < set.size(); i++){
            int cnt = 0;
            for (int j = 0; j < filteredWords.size(); j++){
                if (set.get(i).equals(filteredWords.get(j))){
                    cnt++;
                }
            }
            if (cnt > max){
                max = cnt;
                maxString = set.get(i);
            }
        }
        return maxString;
    }

    //Найти все слова в которых содержатся более 4 уникальных гласных в файле words.txt (выполнять параллельно)
    public List<String> wordsWith5UniqueVowels() {
        List<String> strings = Arrays.asList("ауеыоэяи".split(""));
        List<String> collect = words.parallelStream()
                .filter(s -> new DataService().cnt(s, strings) > 4)
                .collect(Collectors.toList());
        return collect;
    }

    public int cnt(String s, List<String> strings){
        String[] letters = s.split("");
        int cnt = 0;
        for(int i = 0; i < letters.length; i++){
            if (strings.contains(letters[i])){
                cnt++;
            }
        }
        return cnt;
    }

}