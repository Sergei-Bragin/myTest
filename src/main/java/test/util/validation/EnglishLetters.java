package test.util.validation;

import net.sf.oval.configuration.annotation.Constraint;

import java.lang.annotation.*;

/**
 * Created by on 11.04.16.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(checkWith = EnglishLettersCheck.class)
@Documented
public @interface EnglishLetters {
    String message() default "Please use English letters!";
}
