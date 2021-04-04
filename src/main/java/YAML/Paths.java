package YAML;

import java.nio.file.Path;

public class Paths {
    private String path;
    private Types  type;

    public Paths(String path, Types type){
        this.path = path;
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public Types getType() {
        return type;
    }
}
