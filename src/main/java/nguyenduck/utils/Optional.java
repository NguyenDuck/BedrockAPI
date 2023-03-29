package nguyenduck.utils;

import java.lang.annotation.*;

/**
 * Take a number that is using for priority, Default 0
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Optional {
    int value() default 0;
}
