package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import test.entity.Employee;
import test.service.EmployeeService;
import test.service.impl.EmployeeServiceImpl;


/**
 * Created by on 08.04.16.
 */
public class UniqueEmplEmailCheck extends AbstractAnnotationCheck<UniqueEmplEmail> {

    private EmployeeService employeeService = ApplicationContextHolder.getBean(EmployeeServiceImpl.class);

    @Override
    public boolean isSatisfied(Object validatedObject, Object value,
                               OValContext context, Validator validator) throws OValException {

        Employee validate = (Employee) validatedObject;
        Employee empl = employeeService.getByEmail(value.toString());
        String s = empl.getEmail();
        if(!value.equals(s)){
            return true;
        }else if (validate.getId()==null){
            return false;
        }else if(empl.getId().intValue()==validate.getId()){
            return true;
        }else return false;
    }
}
