package nguyenduck.utils;

import java.lang.annotation.*;

/**
 * Take a number that is using for priority, Default 0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Required {
    int value() default 0;
}
