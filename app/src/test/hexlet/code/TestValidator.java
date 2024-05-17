package hexlet.code;

import hexlet.code.schemas.StringSchema;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestValidator {
    @Test
    public void testStingValidator() {
        Validator v = new Validator();
        StringSchema schema = v.string();

        assertThat(schema.isValid(null)).isTrue();
        assertThat(schema.isValid("")).isTrue(); // true

        schema.required();

        assertThat(schema.isValid(null)).isFalse(); // false
        assertThat(schema.isValid("")).isFalse(); // false
        assertThat(schema.isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.isValid("hexlet")).isTrue(); // true

        assertThat(schema.contains("wh").isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.contains("what").isValid("what does the fox say")).isTrue(); // true
        assertThat(schema.contains("whatthe").isValid("what does the fox say")).isFalse(); // false

        assertThat(schema.isValid("what does the fox say")).isTrue(); // false

        var schema1 = v.string();
        assertThat(schema1.minLength(10).minLength(4).isValid("Hexlet")).isTrue(); // true


    }

}
