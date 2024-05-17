package hexlet.code.schemas;

import java.util.*;
import java.util.function.Predicate;

public class StringSchema {
    public StringSchema() {
        this.parameters = new LinkedHashMap<>();
    }

    public Map<String, Predicate> parameters;

    public StringSchema minLength(int length) {
        addParameter("minLength", o -> o.toString().length() >= length);
        return this;
    }

    public StringSchema required() {
        addParameter("required", o -> !o.equals("") && !o.toString().isEmpty());
        return this;
    }

    public StringSchema contains(String string) {
        addParameter("contains", o -> o.toString().contains(string));
        return this;
    }

    public boolean isValid(String string) {
        int count = 0;
        for (Predicate value : parameters.values()) {
            if (value.test(string)) {
                count++;
            } else {
                count--;
            }
        }
        return count > 0;
    }

    public <T> void addParameter(String name, Predicate<T> predicate) {
        this.parameters.put(name, predicate);
    }
}
