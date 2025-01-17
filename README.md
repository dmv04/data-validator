# Data Validator
Data Validator is a library that allows you to check the correctness of data by specific parameters. Data types : strings, int numbers, string maps

### How it works?
```
// Example of nested data validating

var v = new Validator();

var schema = v.map();

// Creating a set of schemes to check each key
Map<String, BaseSchema<String>> schemas = new HashMap<>();

// Creating schemes for each key
schemas.put("firstName", v.string().required());
schemas.put("lastName", v.string().required().minLength(2));

// Delegate created set to method shape
schema.shape(schemas);

// Checking the objects
Map<String, String> human1 = new HashMap<>();
human1.put("firstName", "John");
human1.put("lastName", "Smith");
schema.isValid(human1); // true

Map<String, String> human2 = new HashMap<>();
human2.put("firstName", "John");
human2.put("lastName", null);
schema.isValid(human2); // false

Map<String, String> human3 = new HashMap<>();
human3.put("firstName", "Anna");
human3.put("lastName", "B");
schema.isValid(human3); // false
```
### Installing and Build
```
make install
make build
```
### Running
Use jshell or other compilers
```
import hexlet.code.*
var v = new Validator();
//
vallidated data
//
```
