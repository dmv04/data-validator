package hexlet.code.schemas;

import java.util.Map;
import java.util.function.Predicate;

public class BaseSchema<T> {
    public Map<String, Predicate<T>> parameters;
    public boolean isValid(T value) {
        for (var schemas : parameters.entrySet()) {
            schemas.getValue().test(value);
            if (!schemas.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }

    public void addParameter(String name, Predicate<T> predicate) {
        this.parameters.put(name, predicate);
    }
}
