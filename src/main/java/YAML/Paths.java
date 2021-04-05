package YAML;

import lombok.Data;

@Data
public class Paths {
    private String path;
    private Types  type;

    public Paths(String path, Types type) {
        this.path = path;
        this.type = type;
    }
    public Paths(){}
}
