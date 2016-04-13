package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import test.entity.Employee;
import test.service.EmployeeService;


/**
 * Created by on 08.04.16.
 */
@Component
public class UniqueEmplEmailCheck extends AbstractAnnotationCheck<UniqueEmplEmail> {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public boolean isSatisfied(Object validatedObject, Object value,
                               OValContext context, Validator validator) throws OValException {

        Employee validate = (Employee) validatedObject;
        Employee empl = employeeService.getByEmail(value.toString());
        String s = empl.getEmail();
        if(!value.equals(s)){
            return true;
        } else if(empl.getId()==validate.getId()){
            return true;
        }

        return false;
    }
}
