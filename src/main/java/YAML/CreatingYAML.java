package YAML;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CreatingYAML {
    @SneakyThrows
    public static void main(String[] args) {
        YAMLMapper mapper = new YAMLMapper(new YAMLFactory().disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER));
        List<Paths> pathLine = new ArrayList<>();
        pathLine.add(new Paths("C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\test\\resources\\words.txt", Types.GENERAL));
        pathLine.add(new Paths("C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\test\\resources\\testCase.txt", Types.TEST));
        mapper.writeValue(new File("C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\test\\resources\\paths.yaml"), pathLine);
    }
}
