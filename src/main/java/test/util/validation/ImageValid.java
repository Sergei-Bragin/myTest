package test.util.validation;

import net.sf.oval.configuration.annotation.Constraint;

import java.lang.annotation.*;

/**
 * Created by on 18.04.16.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(checkWith = EnglishLettersCheck.class)
@Documented
public @interface ImageValid {
    String message() default "Please input image jpg/png/gif/bmp";
}
