package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MapSchema<T> extends BaseSchema<Map<String, T>> {
    public MapSchema() {
        this.parameters = new LinkedHashMap();
    }

    public MapSchema<T> required() {
        addParameter("required", Objects::nonNull);
        return this;
    }

    public MapSchema<T> sizeof(int size) {
        addParameter("sizeof", value -> value.size() == size);
        return this;
    }

    public <T> MapSchema shape(Map<String, BaseSchema<T>> schemas) {
        addParameter("shape",
                map -> schemas.entrySet().stream().allMatch(entry -> {
                    var key = entry.getKey();
                    var schema = entry.getValue();
                    T s = (T) map.get(key);
                    return s != null && schema.isValid(s);
                }));
        return this;
    }
}
