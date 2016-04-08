package test.util.validation;

import net.sf.oval.Validator;
import net.sf.oval.configuration.annotation.AbstractAnnotationCheck;
import net.sf.oval.context.OValContext;
import net.sf.oval.exception.OValException;
import test.entity.Department;
import test.service.DepartmentService;
import test.service.impl.DepartmentServiceImpl;

import java.sql.SQLException;

/**
 * Created by on 08.04.16.
 */
public class UniqueNameDepCheck  extends AbstractAnnotationCheck<UniqueNameDep>{

    private DepartmentService departmentService = new DepartmentServiceImpl();

    @Override
    public boolean isSatisfied(Object validatedObject, Object value,
                               OValContext context, Validator validator) throws OValException {
        try {
            Department validate = (Department) validatedObject;
            Department dep = departmentService.getByName(value.toString());
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
