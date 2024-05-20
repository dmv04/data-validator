package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Objects;

public class NumberSchema extends BaseSchema {
    public NumberSchema() {
        this.parameters = new LinkedHashMap();
    }

    public NumberSchema required() {
        addParameter("required", Objects::nonNull);
        return this;
    }

    public NumberSchema positive() {
        addParameter("positive", o -> o == null || (int) o > 0);
        return this;
    }

    public NumberSchema range(int a, int b) {
        addParameter("range", o -> (int) o >= a && (int) o <= b);
        return this;
    }
}
