package ru.oshkina;

import lombok.SneakyThrows;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class StorageService {

    //getter
    private final List<String> content = readFile();
    private final List<String> words = wordsReadFile();

    @SneakyThrows
    private List<String> readFile()  {
            String value = new String(Files.readAllBytes(Paths.get("C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\main\\resources\\words.txt")));
            List<String> list = Arrays.asList(value.split("\r\n"));
            return list;
    }

    @SneakyThrows
    private List<String> wordsReadFile()  {
        String value = new String(Files.readAllBytes(Paths.get("C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\main\\resources\\words.txt")));
        List<String> list = Arrays.asList(value.split("\\PL+"));
        return list;
    }

    public List<String> getContent() {
        return content;
    }
    public List<String> getWords() {
        return words;
    }
}