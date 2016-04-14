package test.util.validation;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.Validator;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;
import org.springframework.beans.factory.annotation.Autowired;
import test.exception.ValidException;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by on 07.04.16.
 */

public class ValidatorOVAL {


    private Validator validator;

    public void setValidator(Validator validator) {
        this.validator = validator;
    }

    public void valid(Object object) throws ValidException {

        List<ConstraintViolation> violations = validator.validate(object);

        Map<String, String> map = new HashMap<>();

        if (violations.size() > 0) {
            for (ConstraintViolation constraintViolation : violations) {
                OValContext context = constraintViolation.getContext();
                if (context instanceof FieldContext) {
                    Field fieldContext = ((FieldContext) context).getField();
                    map.put(fieldContext.getName(), constraintViolation.getMessage());
                }
            }
            throw new ValidException(map);
        }
    }

}
