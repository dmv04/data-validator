package hexlet.code.schemas;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Predicate;

public abstract class BaseSchema<T> {
    protected Map<String, Predicate<T>> parameters = new LinkedHashMap<>();
    public final boolean isValid(T value) {
        for (var schemas : parameters.entrySet()) {
            schemas.getValue().test(value);
            if (!schemas.getValue().test(value)) {
                return false;
            }
        }
        return true;
    }

    public final void addParameter(String name, Predicate<T> predicate) {
        this.parameters.put(name, predicate);
    }
}
