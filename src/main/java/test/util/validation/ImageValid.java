package test.util.validation;

import net.sf.oval.configuration.annotation.Constraint;

import java.lang.annotation.*;

/**
 * Created by on 18.04.16.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(checkWith = ImageValidCheck.class)
@Documented
public @interface ImageValid {
    String message() default "Pleas use image file";
}
