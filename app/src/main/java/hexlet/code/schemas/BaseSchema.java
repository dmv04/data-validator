package hexlet.code.schemas;

import lombok.Setter;

import java.util.Map;
import java.util.function.Predicate;

@Setter
public abstract class BaseSchema<T> {
    private Map<String, Predicate<T>> parameters;
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
