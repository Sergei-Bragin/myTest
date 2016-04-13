package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import org.springframework.stereotype.Component;
import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;


/**
 * Created by on 08.04.16.
 */
@Component
public class UniqueNameDepCheck  extends AbstractAnnotationCheck<UniqueNameDep>{

    private DepartmentService departmentService = ApplicationContextHolder.getBean(DepartmentServiceImpl.class);


    @Override
    public boolean isSatisfied(Object validatedObject, Object value,
                               OValContext context, Validator validator) throws OValException {

        Department validate = (Department) validatedObject;

        Department dep = departmentService.getByName(value.toString());
        String s = dep.getName();
        if(!value.equals(s)){
            return true;
        } else if(dep.getId()==validate.getId()){
            return true;
        }

        return false;

    }

}
