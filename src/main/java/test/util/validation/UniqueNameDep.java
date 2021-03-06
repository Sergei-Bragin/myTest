package test.util.validation;

import net.sf.oval.configuration.annotation.Constraint;

import java.lang.annotation.*;

/**
 * Created by on 08.04.16.
 */
@Target({ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(checkWith = UniqueNameDepCheck.class)
@Documented
public @interface UniqueNameDep {
    String message() default "This name is used!";
}
