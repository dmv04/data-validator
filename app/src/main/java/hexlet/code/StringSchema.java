package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class StringSchema {
    public static void main(String[] args) {
        var test = new StringSchema();
        test.parameters = new ArrayList<>();

        System.out.println(test.contains("wh").isValid("what does"));
        System.out.println(test.minLength(4).isValid("what does"));
        //var test2 = new Predicate<Object>();
    }
    String string;
    List<Predicate> parameters;

    public StringSchema minLength(int length) {
        var schema = this;
        schema.parameters.add(o -> o.toString().length() >= length);
        return schema;
    }

    public StringSchema required() {
        var schema = this;
        schema.parameters.add(Objects::isNull);
        return schema;
    }

    public StringSchema contains(String string) {
        var schema = this;
        schema.parameters.add(o -> o.toString().contains(string));
        return schema;
    }
    
    public boolean isValid(String string) {
        this.string = string;
        if (string == null || string.isEmpty() || this.parameters.isEmpty()) {
            return true;
        }
        var parameters = this.parameters;
        int count = 0;
        for (Predicate parameter : parameters) {
            if (parameter.test(string)) {
                count++;
            } else count--;

        }

        return count > 0;
    }

}
