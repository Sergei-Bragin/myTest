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
    public boolean isSatisfied(Object validatedObject, Object value, OValContext context, Validator validator) throws OValException {
        try {
            Employee validate = (Employee) validatedObject;
            Employee dep = employeeService.getByEmail(value.toString());
            String s = dep.getName();
            if(!value.equals(s)){
                return true;
            } else if(dep.getId()==validate.getId()){
                return true;
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
