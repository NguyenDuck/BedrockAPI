package nguyenduck.exceptions;

import java.lang.reflect.Field;

public final class MissingPropertyException extends RuntimeException {

    public MissingPropertyException(Field field) {
        super("Missing required property '" + field.getName() + "' Class: " + field.getType());
    }

}
