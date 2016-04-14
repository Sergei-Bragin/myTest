package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import org.springframework.stereotype.Component;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;


/**
 * Created by on 08.04.16.
 */
@Component
public class UniqueEmplEmailCheck extends AbstractAnnotationCheck<UniqueEmplEmail> {


    private EmployeeService employeeService = ApplicationContextHolder.getBean(EmployeeServiceImpl.class);

    @Override
    public boolean isSatisfied(Object validatedObject, Object value,
                               OValContext context, Validator validator) throws OValException {

        Employee validate = (Employee) validatedObject;
        Employee empl = employeeService.getByEmail(value.toString());
        if (empl.getId() == null) {
            return true;
        } else if (empl.getId() == validate.getId()) {
            return true;
        }

        return false;
    }
}
