package YAML;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;

import java.io.File;
import java.util.List;

public class ReadingYAML {
    @SneakyThrows
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<Paths> paths = mapper.readValue(new File("C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\main\\resources\\paths.yaml"), new TypeReference<List<Paths>>() {});
        System.out.println(paths.get(0).getType());
    }
}
