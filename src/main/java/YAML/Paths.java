package YAML;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Paths {
    private String path;
    private Types type;

    public Paths() {
    }
}
