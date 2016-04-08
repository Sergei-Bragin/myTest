package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;

import java.sql.SQLException;

/**
 * Created by on 08.04.16.
 */
public class UniqueEmplEmailCheck extends AbstractAnnotationCheck<UniqueEmplEmail> {

    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Override
    public boolean isSatisfied(Object validatedObject, Object valueToValidate, OValContext context, Validator validator) throws OValException {
        Employee empl = null;
        try {
            empl = employeeService.getByEmail(valueToValidate.toString());
        }catch (SQLException e){
            empl.setName(valueToValidate.toString());
        }
        if(empl.getId() == null){
            return true;
        }
        return false;
    }
}
