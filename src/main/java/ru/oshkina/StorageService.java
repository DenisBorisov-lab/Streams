package ru.oshkina;

import lombok.SneakyThrows;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class StorageService {

    //getter
    private final List<String> content;
    private final List<String> words;
    private String value;

    @SneakyThrows
    public StorageService(String path){
        value = new String(Files.readAllBytes(Paths.get(path)));
        content = readFile();
        words = wordsReadFile();
    }

    @SneakyThrows
    private List<String> readFile()  {
           return Arrays.asList(value.split("\r\n"));
    }

    @SneakyThrows
    private List<String> wordsReadFile()  {
        return Arrays.asList(value.split("\\PL+"));
    }

    public List<String> getContent() {
        return content;
    }
    public List<String> getWords() {
        return words;
    }
}