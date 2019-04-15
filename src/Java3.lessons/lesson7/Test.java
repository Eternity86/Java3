package lesson7;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Test {
    int DEFAULT_PRIORITY = 5;
    // создаём приоритет для аннотации, по умолчанию 5
    int priority() default DEFAULT_PRIORITY;
}
