package YAML;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.SneakyThrows;
import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class ReadingYAML {

    @SneakyThrows
    public String read (Types type){
        String path = "C:\\Users\\maibo\\IdeaProjects\\stream-api-test-task\\src\\main\\resources\\paths.yaml";
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<YAML.Paths> paths = mapper.readValue(new File(path), new TypeReference<List<YAML.Paths>>() {});
        List<Paths> collect = paths.stream()
                .filter(s -> s.getType() == type)
                .limit(1)
                .collect(Collectors.toList());
        return collect.get(0).getPath();
    }
}
