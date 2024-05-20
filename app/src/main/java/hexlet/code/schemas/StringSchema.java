package hexlet.code.schemas;

import java.util.LinkedHashMap;

public class StringSchema extends BaseSchema {
    public StringSchema() {
        this.parameters = new LinkedHashMap<>();
    }

    public StringSchema minLength(int length) {
        addParameter("minLength", o -> o.toString().length() >= length);
        return this;
    }

    public StringSchema required() {
        addParameter("required", o -> !(o == null) && !o.toString().isEmpty());
        return this;
    }

    public StringSchema contains(String string) {
        addParameter("contains", o -> o.toString().contains(string));
        return this;
    }
}
