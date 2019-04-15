package lesson7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    // создаём приоритет для аннотации
    int DEFAULT_PRIORITY = 5;

    int priority() default DEFAULT_PRIORITY;
}
